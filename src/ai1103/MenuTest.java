
package ai1103;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuTest extends JFrame {

    JTextArea textArea = new JTextArea();
    JFileChooser fileChooser = new JFileChooser();
    JFrame frame;

    // 이미지 순서: 문서 → 폴더 → 전원
    String[] iconFileNames = {"toolbar", "open", "close"};

    Color[] colorNames = {
            Color.WHITE,
            Color.BLUE,
            Color.MAGENTA
    };

    JButton[] btns = new JButton[6];

    public MenuTest() {
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

            // 버튼 크기 통일
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

        // File 메뉴
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem closeMenuItem = new JMenuItem("Close");

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(closeMenuItem);

        newMenuItem.addActionListener(fileListener);
        saveMenuItem.addActionListener(fileListener);
        openMenuItem.addActionListener(fileListener);
        closeMenuItem.addActionListener(fileListener);

        // Edit 메뉴
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
                textArea.setText("");

                // 두 번째: 파일 열기
            } else if (eBtn == btns[1]) {
                openFile();

                // 세 번째: 종료
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

    // 파일 열기
    public void openFile() {

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();

            if (selectedFile != null) {

                try {
                    textArea.setText(readFile(selectedFile));

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            frame, "파일을 읽을 수 없습니다."
                    );
                }
            }
        }
    }

    // 파일 저장
    public void saveFile() {

        int result = fileChooser.showSaveDialog(frame);

        // 취소하면 저장하지 않음
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File selectedFile = fileChooser.getSelectedFile();

        if (selectedFile == null) {
            return;
        }

        // 같은 이름의 파일이 있으면 덮어쓰기 확인
        if (selectedFile.exists()) {
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

        // readFile()의 FileReader와 같은 기본 인코딩으로 저장
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(selectedFile))) {

            bw.write(textArea.getText());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    frame,
                    "파일을 저장할 수 없습니다.",
                    "저장 오류",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // File 메뉴 이벤트
    ActionListener fileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {

                case "New":
                    textArea.setText("");
                    break;

                case "Save":
                    saveFile();
                    break;

                case "Open":
                    openFile();
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
                new FileReader(selectedFile))) {

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
