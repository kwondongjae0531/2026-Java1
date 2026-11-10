
package ai1103;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MenuTestProject extends JFrame {

    JTextArea textArea = new JTextArea();
    JFileChooser fileChooser = new JFileChooser();
    JFrame frame;

    // 현재 열거나 저장한 파일
    File currentFile = null;

    // PNG 이미지: 문서 → 폴더 → 전원
    String[] iconFileNames = {"toolbar", "open", "close"};

    // 색상 배열
    Color[] colorNames = {
            Color.WHITE,
            Color.BLUE,
            Color.MAGENTA
    };

    // 툴바 버튼 6개
    JButton[] btns = new JButton[6];

    public MenuTestProject() {
        frame = this;

        // 텍스트 입력창 및 스크롤바
        JScrollPane scrollPane = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );
        add(scrollPane, BorderLayout.CENTER);

        // 툴바 생성
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        add(toolBar, BorderLayout.NORTH);

        // 툴바 버튼 6개 생성
        for (int i = 0; i < btns.length; i++) {

            if (i < 3) {

                String imagePath =
                        "/ai1103/" + iconFileNames[i] + ".png";

                java.net.URL imageUrl =
                        getClass().getResource(imagePath);

                if (imageUrl != null) {

                    ImageIcon icon = new ImageIcon(imageUrl);

                    Image image = icon.getImage().getScaledInstance(
                            32, 32, Image.SCALE_SMOOTH
                    );

                    btns[i] = new JButton(new ImageIcon(image));

                } else {
                    System.out.println(
                            "이미지를 찾을 수 없습니다: " + imagePath
                    );

                    btns[i] = new JButton();
                }

            } else {

                // 색상 버튼
                btns[i] = new JButton();
                btns[i].setBackground(colorNames[i - 3]);
                btns[i].setOpaque(true);

                btns[i].setBorder(
                        BorderFactory.createLineBorder(Color.GRAY)
                );
            }

            // 버튼 크기 38x38
            btns[i].setPreferredSize(new Dimension(38, 38));
            btns[i].setMaximumSize(new Dimension(38, 38));
            btns[i].setMinimumSize(new Dimension(38, 38));
            btns[i].setMargin(new Insets(0, 0, 0, 0));

            // 교수님 방식: 하나의 리스너 사용
            btns[i].addActionListener(btnListener);

            toolBar.add(btns[i]);
        }

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // File 메뉴 항목
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");

        // 과제: Save 메뉴 추가
        JMenuItem saveMenuItem = new JMenuItem("Save");

        JMenuItem closeMenuItem = new JMenuItem("Close");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(closeMenuItem);

        // File 메뉴 이벤트 연결
        newMenuItem.addActionListener(fileListener);
        openMenuItem.addActionListener(fileListener);
        saveMenuItem.addActionListener(fileListener);
        closeMenuItem.addActionListener(fileListener);

        // Edit 메뉴 항목
        JMenuItem whiteMenuItem = new JMenuItem("White");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        JMenuItem magentaMenuItem = new JMenuItem("Magenta");

        editMenu.add(whiteMenuItem);
        editMenu.add(blueMenuItem);
        editMenu.add(magentaMenuItem);

        whiteMenuItem.addActionListener(backgroundListener);
        blueMenuItem.addActionListener(backgroundListener);
        magentaMenuItem.addActionListener(backgroundListener);

        // 창 설정
        SetFrame.setFrame(this, "메뉴만들기", 500, 500);
        setTitle("메뉴만들기");
    }

    // 툴바 버튼 이벤트
    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton eBtn = (JButton) e.getSource();

            // 첫 번째: 새 문서
            if (eBtn == btns[0]) {
                newFile();

                // 두 번째: 파일 열기
            } else if (eBtn == btns[1]) {
                openFile();

                // 세 번째: 프로그램 종료
            } else if (eBtn == btns[2]) {
                System.exit(0);
            }

            // 색상 버튼 처리
            for (int i = 0; i < colorNames.length; i++) {

                if (eBtn == btns[i + 3]) {
                    textArea.setBackground(colorNames[i]);
                    break;
                }
            }
        }
    };

    // 새 문서 만들기
    public void newFile() {
        textArea.setText("");
        currentFile = null;
    }

    // 파일 열기
    public void openFile() {

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();

            if (selectedFile != null) {

                try {
                    String content = readFile(selectedFile);

                    textArea.setText(content);
                    currentFile = selectedFile;

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            frame, "파일을 읽을 수 없습니다."
                    );
                }
            }
        }
    }

    // 과제 추가 기능: 파일 저장
    public void saveFile() {

        File targetFile = currentFile;

        // 처음 저장할 때 저장 위치 선택
        if (targetFile == null) {

            int result = fileChooser.showSaveDialog(frame);

            if (result != JFileChooser.APPROVE_OPTION) {
                return;
            }

            targetFile = fileChooser.getSelectedFile();

            if (targetFile == null) {
                return;
            }

            // 이미 파일이 있으면 덮어쓰기 확인
            if (targetFile.exists()) {

                int answer = JOptionPane.showConfirmDialog(
                        frame,
                        "이미 존재하는 파일입니다. 덮어쓰시겠습니까?",
                        "저장 확인",
                        JOptionPane.YES_NO_OPTION
                );

                if (answer != JOptionPane.YES_OPTION) {
                    return;
                }
            }
        }

        // 실제 파일에 메모장 내용 저장
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(targetFile),
                        StandardCharsets.UTF_8
                ))) {

            bw.write(textArea.getText());
            currentFile = targetFile;

            JOptionPane.showMessageDialog(
                    frame, "저장되었습니다."
            );

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    frame, "저장 중 오류가 발생했습니다."
            );
        }
    }

    // File 메뉴 이벤트
    ActionListener fileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {

                case "New":
                    newFile();
                    break;

                case "Open":
                    openFile();
                    break;

                // Save 클릭 시 저장 기능 실행
                case "Save":
                    saveFile();
                    break;

                case "Close":
                    System.exit(0);
                    break;
            }
        }
    };

    // Edit 메뉴 이벤트
    ActionListener backgroundListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Color color = null;

            switch (e.getActionCommand()) {

                case "White":
                    color = Color.WHITE;
                    break;

                case "Blue":
                    color = Color.BLUE;
                    break;

                case "Magenta":
                    color = Color.MAGENTA;
                    break;
            }

            if (color != null) {
                textArea.setBackground(color);
            }
        }
    };

    // 파일 내용 읽기
    public String readFile(File selectedFile) throws IOException {

        StringBuilder totalLines = new StringBuilder();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(selectedFile),
                        StandardCharsets.UTF_8
                ))) {

            String line;

            while ((line = br.readLine()) != null) {
                totalLines.append(line).append("\n");
            }
        }

        return totalLines.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuTest());
    }
}
