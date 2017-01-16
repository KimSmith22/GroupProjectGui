package guiGroupProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.sun.prism.paint.Color;

public class ImageDisplayP1 implements Runnable {

	ImageDisplayP1 id;
    private ItemListener listener;

    private JFrame frame;

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel descriptionLabel;

    private List<ImageInformation> images;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ImageDisplayP1());
    }

    public ImageDisplayP1() {
        this.images = setImageInformation();
    }

 
    @Override
    public void run() {
        frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());

        ImageInformation defaultImageInformation = images.get(0);

        titleLabel = new JLabel(defaultImageInformation.getTitle());
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(titleLabel, BorderLayout.NORTH);

        imageLabel = new JLabel(new ImageIcon(
                defaultImageInformation.getImage()));
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        descriptionLabel = new JLabel(defaultImageInformation.getDescription());
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(descriptionLabel, BorderLayout.SOUTH);

        frame.add(createControlPanel(), BorderLayout.WEST);
        frame.add(imagePanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Images"));
        panel.setLayout(new GridLayout(0, 1));

        ButtonGroup group = new ButtonGroup();

        listener = new ImageListener();

        for (int i = 0; i < images.size(); i++) {
            ImageInformation imageInformation = images.get(i);
            JRadioButton button = new JRadioButton(imageInformation.getTitle());
            if (i == 0) {
                button.setSelected(true);
            }
            button.addItemListener(listener);
            group.add(button);
            panel.add(button);
        }

        return panel;
    }

    private List<ImageInformation> setImageInformation() {
        List<ImageInformation> images = new ArrayList<ImageInformation>();

        // Here, you would get your images
        Image image1 = getImage("shelby1.jpg");
        Image image2 = getImage("challenger1.jpg");
        Image image3 = getImage("corvette1.jpg");
        Image image4 = getImage("porche1.jpg");
        Image image5 = getImage("camaro1.jpg");
        //Image image6 = getImage("shelby2.png");


        images.add(new ImageInformation(image1, "Shelby", "Image 1 Description"));
        images.add(new ImageInformation(image2, "Challenger", "Image 2 Description"));
        images.add(new ImageInformation(image3, "Corvette", "Image 3 Description"));
        images.add(new ImageInformation(image4, "Porche", "Image 4 Description"));
        images.add(new ImageInformation(image5, "Camaro", "Image 5 Description"));
       // images.add(new ImageInformation(image6, "Image 6", "Image 6 Description"));

        return images;
    }

    private Image getImage(String fileName) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ImageInformation getImageInformation(String title) {
        for (ImageInformation imageInformation : images) {
            if (title.equals(imageInformation.getTitle())) {
                return imageInformation;
            }
        }

        return null;
    }

    public class ImageListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                JRadioButton button = (JRadioButton) event.getItem();
                String labelText = button.getText();
                ImageInformation imageInformation = getImageInformation(labelText);
                if (imageInformation != null) {
                    titleLabel.setText(imageInformation.getTitle());
                    imageLabel.setIcon(new ImageIcon(imageInformation
                            .getImage()));
                    descriptionLabel.setText(imageInformation.getDescription());
                }
            }
        }

    }

    public class ImageInformation {

        private final Image image;

        private final String title;
        private final String description;

        public ImageInformation(Image image, String title, String description) {
            this.image = image;
            this.title = title;
            this.description = description;
        }

        public Image getImage() {
            return image;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

    }
}
