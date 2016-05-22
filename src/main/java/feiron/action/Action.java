package feiron.action;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 1 on 22.05.2016.
 */
public class Action extends JFrame {
    private String title;
    private Dimension dimension;

    JMenuBar menuBar = new JMenuBar();
    JMenu view = new JMenu("Вид");
    JMenu editMenu = new JMenu("Правка");
    JMenu helpMenu = new JMenu("Справка");

    JMenuItem table = new JMenuItem("Таблица рассчёта");
    JMenuItem roof1 = new JMenuItem("Кровля односкатная");
    JMenuItem roof2 = new JMenuItem("Кровля двускатная");
    JMenuItem fence = new JMenuItem("Забор");
    // правка
    JMenuItem backMenuItem = new JMenuItem("Назад");
    JMenuItem copyMenuItem = new JMenuItem("Копировать");
    JMenuItem pastMenuItem = new JMenuItem("Вставить");
    JMenuItem saveMenuItem = new JMenuItem("Сохранить");
    JMenuItem saveUsMenuItem = new JMenuItem("Сохранить как");
    //help
    JMenuItem infoMenuItem = new JMenuItem("Справка");
    JMenuItem aboutAppMenuItem = new JMenuItem("О программе");

    JLabel label1 = new JLabel("Стоимость металла за тонну:");

    JLabel label2 = new JLabel("кол-во тонн:");
    JLabel label3 = new JLabel("цена за тонну");
    JLabel label4 = new JLabel("доставка");
    JLabel label5 = new JLabel("Итого: ");


    JLabel label6 = new JLabel("Расчет веса погонного метра в тонне:");

    JLabel label7 = new JLabel("Толщина металла");
    JLabel label8 = new JLabel("вес погонного метра ");


    JTextField thick = new JTextField(); // толщина металла
    JLabel weight = new JLabel(); //вес метра погонного

    JLabel lPog = new JLabel("Погонных метров в тонне:");

    JLabel lPogField = new JLabel(); // пог. метров в тонне

    JLabel label10 = new JLabel("Расчет количества м² в тонне:");

    //    JLabel label11 = new JLabel("кол-во погонных метров");
    JLabel label12 = new JLabel("общая ширина профиля");
    JLabel label14 = new JLabel("кол-во м²");
    //    JTextField field10 = new JTextField();
    JTextField field11 = new JTextField();
    JLabel field12 = new JLabel();

    JLabel label15 = new JLabel("Расчет стоимости кв. метра:");

    //    JLabel label16 = new JLabel("ст-ть металла с доставкой");
    JLabel label17 = new JLabel("переработка");
    //    JLabel label18 = new JLabel("прибыль");
//    JLabel label19 = new JLabel("кол-во м²");
    JLabel label20 = new JLabel("цена");


    //    JTextField field16 = new JTextField();
    JTextField field17 = new JTextField();
    //    JTextField field18 = new JTextField();
//    JTextField field19 = new JTextField();
    JLabel field20 = new JLabel();

    JTextField tonn = new JTextField();
    JTextField priceOfTonn = new JTextField();
    JTextField delivery = new JTextField();
    JLabel result = new JLabel();

    JButton resultButton = new JButton("Ok");

    public Action(String title, Dimension dimension) {
        this.title = title;
        this.dimension = dimension;
    }

    public void init() {
        setTitle(title);
        setSize(dimension);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);


        setJMenuBar(menuBar); //добавляем МенюБар на форму
        menuBar.add(view); //добавляем Меню на МенюБар
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        //добавляем подпункты в меню
        view.add(table);
        view.add(roof1);
        view.add(roof2);
        view.addSeparator();
        view.add(fence);

        editMenu.add(backMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pastMenuItem);
        editMenu.add(saveMenuItem);
        editMenu.add(saveUsMenuItem);

        helpMenu.add(infoMenuItem);
        helpMenu.addSeparator();
        helpMenu.add(aboutAppMenuItem);

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT", "*.XLS", "*.*");
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(filter);
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                        writer.write("Общая ширина профиля: " + field11.getText() + " м; ");
                        writer.write("Стоимость 1 м.кв.: " + field20.getText() + " грн/м.кв; ");
                        System.out.println("a: " + field20.getText());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });


        resultButton.addActionListener(new ResultActionListener());
        aboutAppMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("О программе");
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);

                frame.setLayout(new GridBagLayout());


                JLabel aboutAppLabel = new JLabel();

                aboutAppLabel.setSize(400, 600);
                frame.add(aboutAppLabel);
                aboutAppLabel.setText("<html><img src=\"http://www.feiron.com.ua/img/logo-1.jpg?1423596380" + "alt=\"альтернативный текст" +
                        "<p>FEIRON профнастил " +
                        "<p>Версия 1.0 (сборка 396)" +
                        "<p>©Корпорация Фейрон (Feiron Corporation), 2016. Все проава защищены." +
                        "<p>Программное обеспечение Таблица рассчетов для металлопроката 1.0" +
                        "<p>профессиональная и пользовательский интерфейс в ней защищены правами" +
                        "<p>на торговые знаки и иные объекты интеллектуальной собственности" +
                        "<p>в Украине и других странах." +
                        "<p> <a href=\"http://www.feiron.com.ua\">www.feiron.com.ua</a></html>");
//                add(aboutAppLabel, new GridBagConstraints(1, 7, 1, 1, 1, 1,
//                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                        new Insets(2, 2, 2, 2), 0, 0));

                frame.setVisible(true);
            }

        });


        setLayout(new GridBagLayout());
        label1.setForeground(Color.GREEN);
        label5.setForeground(Color.RED);
        lPog.setForeground(Color.RED);
        label10.setForeground(Color.GREEN);
        label15.setForeground(Color.GREEN);
        label20.setForeground(Color.RED);
        label6.setForeground(Color.GREEN);
        label8.setForeground(Color.RED);
        label14.setForeground(Color.RED);
        result.setForeground(Color.RED);
        lPogField.setForeground(Color.RED);
        weight.setForeground(Color.RED);

        add(thick, new GridBagConstraints(1, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(weight, new GridBagConstraints(1, 8, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(lPog, new GridBagConstraints(0, 9, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(lPogField, new GridBagConstraints(1, 9, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(label10, new GridBagConstraints(0, 10, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
//        add(label11, new GridBagConstraints(0, 11, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
        add(label12, new GridBagConstraints(0, 12, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(label14, new GridBagConstraints(0, 14, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        //field10 - 12
//        add(field10, new GridBagConstraints(1, 11, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
        add(field11, new GridBagConstraints(1, 12, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(field12, new GridBagConstraints(1, 14, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(label15, new GridBagConstraints(0, 15, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
//        add(label16, new GridBagConstraints(0, 16, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
        add(label17, new GridBagConstraints(0, 17, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
//        add(label18, new GridBagConstraints(0, 18, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
//        add(label19, new GridBagConstraints(0, 19, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
        add(label20, new GridBagConstraints(0, 20, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        //field16 - 20 Расчет стоимости кв. метра
//        add(field16, new GridBagConstraints(1, 16, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
        add(field17, new GridBagConstraints(1, 17, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
//        add(field18, new GridBagConstraints(1, 18, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
//        add(field19, new GridBagConstraints(1, 19, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));
        add(field20, new GridBagConstraints(1, 20, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(tonn, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(priceOfTonn, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(delivery, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(result, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        //Стоимость металла за тонну
        add(label1, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        add(label2, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(label3, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(label4, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(label5, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));


        // label рассчёт веса метра погоного в тонне
        add(label6, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(label7, new GridBagConstraints(0, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(label8, new GridBagConstraints(0, 8, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(resultButton, new GridBagConstraints(1, 21, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        setVisible(true);
        pack();
    }


    public class ResultActionListener implements ActionListener {
        private static final double K1 = 4.91;
        private static final double K2 = 0.5;
        private static final double P = 1.07;

        @Override
        public void actionPerformed(ActionEvent e) {


            double i1 = Double.parseDouble(tonn.getText());
            double i2 = Double.parseDouble(priceOfTonn.getText());
            double i3 = Double.parseDouble(delivery.getText());
            double z = i3 / i1 + i2; //стоимость металла за тонну
            System.out.println(z);

            double thick1 = Double.parseDouble(thick.getText());
            double weigthT = thick1 * K1 / K2; // вес погонного метра
            double pogMT = 1000 / weigthT;

            double pr = Double.parseDouble(field11.getText()); // получаем общую ширину профиля
            double mKv = pogMT * pr; // рассчет кол-ва м.кв. в 1 тонне

            double pererab = Double.parseDouble(field17.getText());
            System.out.println(pererab);
            double prib = z * P - z; // прибыль 7%
            System.out.println(prib);
            double priceOfTriangle = (z + pererab + prib) / mKv; // цена за 1 м.кв.


            String b = Double.toString(z);
            result.setText(b + " грн./т"); // цена за тонну
            String w = Double.toString(weigthT);
            weight.setText(w + " кг/м.пог."); // вес погонного метра

            String lPogMT = Double.toString(pogMT);
            lPogField.setText(lPogMT + " м.пог/т"); // метров погонных в тонне

            String mKvd = Double.toString(mKv);
            field12.setText(mKvd);

            String priceOfTriangle1 = Double.toString(priceOfTriangle);
            field20.setText(priceOfTriangle1);
        }
    }
}
