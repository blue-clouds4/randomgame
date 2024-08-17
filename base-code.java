import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

//for htop
import org.fusesource.jansi.AnsiConsole;

class im {
    private int cubeX, cubeY;
    private final int cubeSize = 50;
    private JTextArea consoleOutput;
    private JTextField consoleInput;
    private boolean isPhase1Running = false;
    private String currentCharacter = "Hero"; // Default character

    public static void main(String[] args) {
        im call = new im();
        call.birth();
    }

    // Method to handle birth scene
    void birth() {
        System.out.println("What is his name?");
        new Thread(() -> playAudio("./birth.mp3")).start();

        try {
            Thread.sleep(7000); // Delay for 7 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        displayCenteredASCIIArt();
        new Timer(4000, e -> phase1()).start();
    }

    void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();

            while (audioClip.isRunning()) {
                Thread.sleep(10);
            }
            audioClip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void displayCenteredASCIIArt() {
        JFrame frame = new JFrame("ASCII Art Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        JLabel asciiArtLabel = new JLabel(
            "<html><pre style='text-align:center;'>██████╗  █████╗ ███╗   ██╗██████╗  ██████╗ ███╗   ███╗<br>" +
            "██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗████╗ ████║<br>" +
            "██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██╔████╔██║<br>" +
            "██╔══██╗██╔══██║██║╚██╗██║██║  ██║██║   ██║██║╚██╔╝██║<br>" +
            "██║  ██║██║  ██║██║ ╚████║██████╔╝╚██████╔╝██║ ╚═╝ ██║<br>" +
            "╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝     ╚═╝</pre></html>",
            SwingConstants.CENTER
        );
        frame.add(asciiArtLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frame.dispose();
    }

    void phase1() {
        new Thread(() -> playAudio("./background_music.mp3")).start();

        JFrame frame = new JFrame("Interactive Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        JPanel cubePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(cubeX, cubeY, cubeSize, cubeSize);
            }
        };
        cubePanel.setBackground(Color.BLACK);
        frame.add(cubePanel, BorderLayout.CENTER);

        JPanel consolePanel = new JPanel(new BorderLayout());
        consolePanel.setPreferredSize(new Dimension(frame.getWidth(), 200));

        consoleOutput = new JTextArea();
        consoleOutput.setEditable(false);
        consoleOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        consoleOutput.setBackground(Color.BLACK);
        consoleOutput.setForeground(Color.GREEN);
        consolePanel.add(new JScrollPane(consoleOutput), BorderLayout.CENTER);

        consoleInput = new JTextField();
        consoleInput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        consoleInput.setBackground(Color.BLACK);
        consoleInput.setForeground(Color.GREEN);
        consoleInput.addActionListener(e -> processCommand());
        consolePanel.add(consoleInput, BorderLayout.SOUTH);

        frame.add(consolePanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cubeX = cubePanel.getWidth() / 2 - cubeSize / 2;
        cubeY = cubePanel.getHeight() / 2 - cubeSize / 2;

        cubePanel.setFocusable(true);
        cubePanel.requestFocusInWindow();
        cubePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (isPhase1Running) {
                    int key = e.getKeyCode();
                    switch (key) {
                        case KeyEvent.VK_W: cubeY = Math.max(cubeY - 10, 0); break;
                        case KeyEvent.VK_S: cubeY = Math.min(cubeY + 10, cubePanel.getHeight() - cubeSize); break;
                        case KeyEvent.VK_A: cubeX = Math.max(cubeX - 10, 0); break;
                        case KeyEvent.VK_D: cubeX = Math.min(cubeX + 10, cubePanel.getWidth() - cubeSize); break;
                    }
                    cubePanel.repaint();
                }
            }
        });

        consoleOutput.append("use 'help' to list all present commands\n");
        isPhase1Running = true;
    }

    void processCommand() {
        String command = consoleInput.getText().trim();
        consoleOutput.append("> " + command + "\n");
        consoleInput.setText("");

        switch (command.toLowerCase()) {
            case "help":
                consoleOutput.append("Available commands:\n");
                consoleOutput.append("- skip: to skip a scene\n");
                consoleOutput.append("- help: lists all present commands\n");
                consoleOutput.append("- switch: switch between characters\n");
                consoleOutput.append("- ls: list present files in a directory\n");
                consoleOutput.append("- cd: changes directories\n");
                consoleOutput.append("- pwd: lists present directory\n");
                consoleOutput.append("- exit/shutdown: to leave the game\n");
                consoleOutput.append("- sudo rf -rm: to kill all of the present files of the game\n");
                consoleOutput.append("- use: to use a particular tool\n");
                consoleOutput.append("- htop: to list present memory usage and CPU usage\n");
                break;
            case "skip":
                consoleOutput.append("Skipping scene...\n");
                skipScene();
                break;
            case "switch":
                changeCharacter();
                break;
            case "ls":
                listFilesAndDirectories();
                break;
            case "cd":
                processChangeDirectory(consoleInput.getText().trim());
                break;
            case "pwd":
                processPrintWorkingDirectory();
                break;
            case "exit":
            case "shutdown":
                consoleOutput.append("Exiting game...\n");
                System.exit(0);
                break;
            case "sudo rf -rm":
                processDeleteAllFiles();
                break;
            case "use":
                processUseTool(consoleInput.getText().trim());
                break;
            case "htop":
                processMemoryAndCPUUsage();
                break;
            default:
                consoleOutput.append("Unknown command. Type 'help' for a list of commands.\n");
                break;
        }
    }

    void skipScene() {
        // implement logic to next scene
        System.out.println("Skipping to the next scene...");
    }

    void changeCharacter() {
        
        if ("Hero".equals(currentCharacter)) {
            currentCharacter = "blue";
        } else {
            currentCharacter = "Hero";
        }
        consoleOutput.append("Character switched to: " + currentCharacter + "\n");
    }

    void listFilesAndDirectories() {
        try {
            Path homeDir = Paths.get("./home");
            if (Files.exists(homeDir)) {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(homeDir);
                consoleOutput.append("Files and directories in ./home:\n");
                for (Path path : directoryStream) {
                    consoleOutput.append(path.getFileName().toString() + "\n");
                }
                directoryStream.close();
            } else {
                consoleOutput.append("./home directory does not exist.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            consoleOutput.append("Error reading directory.\n");
        }
    }

    void processChangeDirectory(String newDir) {
        try {
            Path newPath = Paths.get(newDir);
            if (Files.isDirectory(newPath)) {
                consoleOutput.append("Changed directory to: " + newPath.toString()
                consoleOutput.append("Changed directory to: " + newPath.toString() + "\n");
                // Here you can update the current working directory if necessary
            } else {
                consoleOutput.append("Directory not found: " + newDir + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            consoleOutput.append("Error changing directory.\n");
        }
    }

    void processPrintWorkingDirectory() {
        try {
            Path currentDir = Paths.get("").toAbsolutePath();
            consoleOutput.append("Current directory: " + currentDir.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            consoleOutput.append("Error retrieving current directory.\n");
        }
    }

    void processDeleteAllFiles() {
        try {
            Path homeDir = Paths.get("./home");
            if (Files.exists(homeDir)) {
                Files.walk(homeDir)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                consoleOutput.append("All files in ./home have been deleted.\n");
            } else {
                consoleOutput.append("./home directory does not exist.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            consoleOutput.append("Error deleting files.\n");
        }
    }

    void processUseTool(String toolName) {
        consoleOutput.append("Using tool: " + toolName + "\n");
        // Implement logic for using a specific tool
    }

    void processMemoryAndCPUUsage() {
        // Simulate memory and CPU usage output
        try {
            Sigar sigar = new Sigar();
            Mem memory = sigar.getMem();
            CpuPerc cpu = sigar.getCpuPerc();

            consoleOutput.append("Memory Usage:\n");
            consoleOutput.append("Total: " + memory.getTotal() / 1024 / 1024 + " MB\n");
            consoleOutput.append("Used: " + memory.getUsed() / 1024 / 1024 + " MB\n");
            consoleOutput.append("Free: " + memory.getFree() / 1024 / 1024 + " MB\n");

            consoleOutput.append("CPU Usage:\n");
            consoleOutput.append("User: " + CpuPerc.format(cpu.getUser()) + "\n");
            consoleOutput.append("System: " + CpuPerc.format(cpu.getSys()) + "\n");
            consoleOutput.append("Idle: " + CpuPerc.format(cpu.getIdle()) + "\n");
        } catch (SigarException e) {
            e.printStackTrace();
            consoleOutput.append("Error retrieving memory and CPU usage.\n");
        }
    }
}
