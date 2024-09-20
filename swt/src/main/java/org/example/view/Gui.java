package org.example.view;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;


public class Gui {
    static Display display = new Display();
    static Shell shell = new Shell(display);
    static GridLayout layout = new GridLayout();

    public static void run() {
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
        gdLeft.widthHint = WIDTH/3;

        // Grid para la columna derecha
        GridData gdRight = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 4);

        // Retornar todos los países
        Button b1 = new Button(shell, SWT.PUSH);
        b1.setText("GetAllPaises");
        b1.setLayoutData(gdLeft);

        // Label vacío para dejar libre la mitad derecha
        Label label = new Label(shell, SWT.NONE);
        label.setLayoutData(gdRight);

        // Buscar por id
        Button b3 = new Button(shell, SWT.PUSH);
        b3.setText("GetById");
        b3.setLayoutData(gdLeft);

        // Hacer la Query
        Button b4 = new Button(shell, SWT.PUSH);
        b4.setText("Query del ejercicio 02");
        b4.setLayoutData(gdLeft);

        //
        Button b5 = new Button(shell, SWT.PUSH);
        b5.setText("B5");
        b5.setLayoutData(gdLeft);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }

        display.dispose();
    }

    private static Point centerScreen(int width, int height) {
        Rectangle screenBounds = display.getBounds();
        int x = (screenBounds.width - width) / 2;
        int y = (screenBounds.height - height) / 2;

        return new Point(x, y);
    }

}
