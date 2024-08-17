import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

class im {
    private int cubeX, cubeY;
    private final int cubeSize = 50;
    private JTextArea consoleOutput;
    private JTextField consoleInput;
    private boolean isPhase1Running = false;

    public static void main(String[] args) {
        // birth of bro
        im call = new im();
        call.birth();
    }

    // there, there being born a hero
    void birth() {
        System.out.println("What is his name?");

        // Play audio in a separate thread during the delay
        new Thread(() -> playAudio("./birth.mp3")).start();

        try {
            Thread.sleep(7000); // Delay for 7 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Display ASCII art in the center
        displayCenteredASCIIArt();

        // After 4 seconds, start the interactive console with the navigable white cube
        new Timer(4000, e -> phase1()).start();
    }

    void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();

            // Keep the thread alive to let the audio play in the background
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
        // Create a frame to display the ASCII art
        JFrame frame = new JFrame("ASCII Art Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // ASCII art as a JLabel with centered alignment
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

        // Show the frame
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);

        // Keep the ASCII art displayed for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the frame after displaying the ASCII art
        frame.dispose();
    }

    void phase1() {
        // Start playing background music
        new Thread(() -> playAudio("./background_music.mp3")).start();

        // Create the main frame
        JFrame frame = new JFrame("Interactive Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        // Panel for the navigable cube
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

        // Console panel below the cube
        JPanel consolePanel = new JPanel(new BorderLayout());
        consolePanel.setPreferredSize(new Dimension(frame.getWidth(), 200));

        // Console output area
        consoleOutput = new JTextArea();
        consoleOutput.setEditable(false);
        consoleOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        consoleOutput.setBackground(Color.BLACK);
        consoleOutput.setForeground(Color.GREEN);
        consolePanel.add(new JScrollPane(consoleOutput), BorderLayout.CENTER);

        // Console input area
        consoleInput = new JTextField();
        consoleInput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        consoleInput.setBackground(Color.BLACK);
        consoleInput.setForeground(Color.GREEN);
        consoleInput.addActionListener(e -> processCommand());
        consolePanel.add(consoleInput, BorderLayout.SOUTH);

        frame.add(consolePanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Initialize cube position
        cubeX = cubePanel.getWidth() / 2 - cubeSize / 2;
        cubeY = cubePanel.getHeight() / 2 - cubeSize / 2;

        // Key listener to navigate the cube
        cubePanel.setFocusable(true);
        cubePanel.requestFocusInWindow();
        cubePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (isPhase1Running) {
                    int key = e.getKeyCode();
                    switch (key) {
                        case KeyEvent.VK_W: cubeY = Math.max(cubeY - 10, 0); break; // Move up
                        case KeyEvent.VK_S: cubeY = Math.min(cubeY + 10, cubePanel.getHeight() - cubeSize); break; // Move down
                        case KeyEvent.VK_A: cubeX = Math.max(cubeX - 10, 0); break; // Move left
                        case KeyEvent.VK_D: cubeX = Math.min(cubeX + 10, cubePanel.getWidth() - cubeSize); break; // Move right
                    }
                    cubePanel.repaint();
                }
            }
        });

        // Initial message in console
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
                // Add logic to skip the scene
                break;
            case "switch":
                consoleOutput.append("Switching characters...\n");
                // Add logic to switch characters
                break;
            case "ls":
                listFilesAndDirectories();
                break;
            case "cd":
                consoleOutput.append("Changing directory...\n");
                // Add logic to change directories
                break;
            case "pwd":
                consoleOutput.append("Listing present directory...\n");
                // Add logic to list the present directory
                break;
            case "exit":
            case "shutdown":
                consoleOutput.append("Exiting game...\n");
                System.exit(0);
                break;
            case "sudo rf -rm":
                consoleOutput.append("Killing all present files...\n");
                // Add logic to delete all files of the game
                break;
            case "use":
                consoleOutput.append("Using a particular tool...\n");
                // Add logic to use a particular tool
                break;
            case "htop":
                consoleOutput.append("Listing memory and CPU usage...\n");
                // Add logic to list memory and CPU usage
                break;
            default:
                consoleOutput.append("Unknown command. Type 'help' for a list of commands.\n");
                break;
        }
    }

    void listFilesAndDirectories() {
        try {
            Path homeDir = Paths.get("./home");
            if (Files.exists(homeDir)) {
                List<String> files = new ArrayList
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
        // Implement the logic to change directories
        // You might want to keep track of the current directory
        // and update it based on user input.
        // This is a simple demonstration:
        try {
            Path newPath = Paths.get(newDir);
            if (Files.isDirectory(newPath)) {
                consoleOutput.append("Changed directory to: " + newPath.toString() + "\n");
                // Update the current directory variable if you're keeping track of it
            } else {
                consoleOutput.append("Directory does not exist.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            consoleOutput.append("Error changing directory.\n");
        }
    }

    void processPrintWorkingDirectory() {
        // Implement logic to list the present directory
        // Example output for the current directory
        consoleOutput.append("Present directory: ./home\n");
    }

    void processDeleteAllFiles() {
        try {
            Path homeDir = Paths.get("./home");
            if (Files.exists(homeDir)) {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(homeDir);
                for (Path path : directoryStream) {
                    Files.delete(path);
                }
                directoryStream.close();
                consoleOutput.append("All files in ./home have been deleted.\n");
            } else {
                consoleOutput.append("./home directory does not exist.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            consoleOutput.append("Error deleting files.\n");
        }
    }

    void processMemoryAndCPUUsage() {
        // This is a placeholder for listing memory and CPU usage.
        // Java does not have a built-in way to get detailed system metrics, but you can use external libraries or OS commands.
        consoleOutput.append("Memory and CPU usage reporting is not implemented.\n");
    }

    void processUseTool(String toolName) {
        // Implement logic to use a particular tool
        consoleOutput.append("Using tool: " + toolName + "\n");
    }
}
