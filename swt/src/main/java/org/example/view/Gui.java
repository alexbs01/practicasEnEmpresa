package org.example.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.example.controller.Controller;


public class Gui {
    static Display display = new Display();

    public static void run() {
        Shell shell = new Shell(display);
        GridLayout layout = new GridLayout();
        final int NUM_COLS_LAYOUT = 3;
        final int WIDTH = (int) (display.getBounds().width * 0.7);
        final int HEIGHT = (int) (display.getBounds().height * 0.7);

        layout.numColumns = NUM_COLS_LAYOUT;

        shell.setLayout(layout);
        shell.setSize(WIDTH, HEIGHT);
        shell.setLocation(centerScreen(WIDTH, HEIGHT));
        shell.setText("JJOO");

        // Grid para la columna izquierda
        GridData gdLeft = new GridData(SWT.FILL, SWT.FILL, false, true);
        gdLeft.widthHint = WIDTH / 3;

        // Grid para la columna derecha
        GridData gdRight = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 5);

        GridData gdBottom = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);

        // Retornar todos los países
        Button buttonGetAllPaises = new Button(shell, SWT.PUSH);
        buttonGetAllPaises.setText("GetAllPaises");
        buttonGetAllPaises.setLayoutData(gdLeft);

        // Tabla
        Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLayoutData(gdRight);
        Device device = Display.getCurrent();
        Color background = new Color(device, 50, 50, 50);
        Color foreground = new Color(device, 255, 255, 255);
        table.setBackground(background);
        table.setForeground(foreground);

        // Buscar por id
        Button buttonGetById = new Button(shell, SWT.PUSH);
        buttonGetById.setText("GetById");
        buttonGetById.setLayoutData(gdLeft);

        // Hacer la Query
        Button buttonQuery = new Button(shell, SWT.PUSH);
        buttonQuery.setText("Query del ejercicio 02");
        buttonQuery.setLayoutData(gdLeft);

        // addPais
        Button buttonAddPais = new Button(shell, SWT.PUSH);
        buttonAddPais.setText("AddPais");
        buttonAddPais.setLayoutData(gdLeft);

        // updatePais
        Button buttonUpdatePais = new Button(shell, SWT.PUSH);
        buttonUpdatePais.setText("UpdatePais");
        buttonUpdatePais.setLayoutData(gdLeft);

        SelectionAdapter selectionListener = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                table.removeAll();
                deleteColumns(table);
                table.update();

                Controller controller = Controller.getInstance();

                if (e.getSource() == buttonGetAllPaises) {
                    controller.buttonGetAllPaises(table);

                } else if (e.getSource() == buttonGetById) {
                    String idToSearch = windowGetById();
                    controller.buttonGetPaisById(table, idToSearch);

                } else if (e.getSource() == buttonQuery) {
                    controller.buttonQuery(table);

                } else if (e.getSource() == buttonAddPais) {
                    String[] paisData = windowAddPais();
                    controller.buttonAddPais(table, paisData[0], paisData[1], paisData[2]);
                } else if (e.getSource() == buttonUpdatePais) {
                    String id = windowGetById();
                    if (id != null) {
                        String[] paisData = controller.getPaisByID(id);
                        String[] paisNewData = windowUpdatePais(paisData);
                        controller.buttonUpdatePais(table, id, paisNewData);
                    }

                }
                table.redraw();
            }
        };

        buttonGetAllPaises.addSelectionListener(selectionListener);
        buttonGetById.addSelectionListener(selectionListener);
        buttonQuery.addSelectionListener(selectionListener);
        buttonAddPais.addSelectionListener(selectionListener);
        buttonUpdatePais.addSelectionListener(selectionListener);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }

        display.dispose();
    }

    private static String windowGetById() {
        final String[] result = new String[1];  // Usamos un array para almacenar el valor capturado
        Display display = Display.getDefault();  // Asegúrate de tener acceso a display
        int width = 400;
        int height = 300;

        FillLayout layout = new FillLayout(SWT.VERTICAL);
        layout.marginHeight = 20;
        layout.marginWidth = 20;
        layout.spacing = 20;

        Shell shell = new Shell(display);
        shell.setText("FindById");
        shell.setSize(width, height);
        shell.setLayout(layout);
        shell.setLocation(centerScreen(width, height));

        Text textId = new Text(shell, SWT.BORDER);
        textId.setMessage("ID");

        Button buttonInNewWindow = new Button(shell, SWT.PUSH);
        buttonInNewWindow.setText("Aceptar");

        buttonInNewWindow.addListener(SWT.Selection, event -> {
            result[0] = textId.getText();
            shell.dispose();
        });

        shell.open();

        // Mantener la ventana activa hasta que se cierre
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        // Retornar el valor ingresado por el usuario
        return result[0];
    }

    private static String[] windowAddPais() {
        final String[] result = new String[3];  // Usamos un array para almacenar el valor capturado
        Display display = Display.getDefault();  // Asegúrate de tener acceso a display
        int width = 400;
        int height = 300;

        FillLayout layout = new FillLayout(SWT.VERTICAL);
        layout.marginHeight = 20;
        layout.marginWidth = 20;
        layout.spacing = 20;

        Shell shell = new Shell(display);
        shell.setText("Add Pais");
        shell.setSize(width, height);
        shell.setLayout(layout);
        shell.setLocation(centerScreen(width, height));

        Text textNombrePais = new Text(shell, SWT.BORDER);
        textNombrePais.setMessage("Nombre Pais");

        Text textCodigoPais = new Text(shell, SWT.BORDER);
        textCodigoPais.setMessage("Codigo Pais");

        Text textValorPais = new Text(shell, SWT.BORDER);
        textValorPais.setMessage("Valor Pais");

        Button buttonInNewWindow = new Button(shell, SWT.PUSH);
        buttonInNewWindow.setText("Aceptar");

        buttonInNewWindow.addListener(SWT.Selection, event -> {
            result[0] = textNombrePais.getText();
            result[1] = textCodigoPais.getText();
            result[2] = textValorPais.getText();
            shell.dispose();
        });

        shell.open();

        // Mantener la ventana activa hasta que se cierre
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        // Retornar el valor ingresado por el usuario
        return result;
    }

    private static String[] windowUpdatePais(String[] paisData) {
        if (paisData.length == 0) return new String[0];

        final String[] result = new String[3];  // Usamos un array para almacenar el valor capturado
        Display display = Display.getDefault();  // Asegúrate de tener acceso a display
        int width = 400;
        int height = 300;

        FillLayout layout = new FillLayout(SWT.VERTICAL);
        layout.marginHeight = 20;
        layout.marginWidth = 20;
        layout.spacing = 20;

        Shell shell = new Shell(display);
        shell.setText("Add Pais");
        shell.setSize(width, height);
        shell.setLayout(layout);
        shell.setLocation(centerScreen(width, height));

        Text textNombrePais = new Text(shell, SWT.BORDER);
        textNombrePais.setText(paisData[0]);

        Text textCodigoPais = new Text(shell, SWT.BORDER);
        textCodigoPais.setText(paisData[1]);

        Text textValorPais = new Text(shell, SWT.BORDER);
        textValorPais.setText(paisData[2]);

        Button buttonInNewWindow = new Button(shell, SWT.PUSH);
        buttonInNewWindow.setText("Aceptar");

        buttonInNewWindow.addListener(SWT.Selection, event -> {
            result[0] = textNombrePais.getText();
            result[1] = textCodigoPais.getText();
            result[2] = textValorPais.getText();
            shell.dispose();
        });

        shell.open();

        // Mantener la ventana activa hasta que se cierre
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        // Retornar el valor ingresado por el usuario
        return result;
    }

    private static Point centerScreen(int width, int height) {
        Rectangle screenBounds = display.getBounds();
        int x = (screenBounds.width - width) / 2;
        int y = (screenBounds.height - height) / 2;

        return new Point(x, y);
    }

    private static void deleteColumns(Table table) {
        TableColumn[] columns = table.getColumns();
        for (TableColumn column : columns) {
            column.dispose();
        }
    }

}
