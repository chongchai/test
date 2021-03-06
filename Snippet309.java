package test;
import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet309 {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell();
		shell.setLayout(new GridLayout(1, true));
		final Text text;

//		Listener listener = event -> {
//			Text t = (Text) event.widget;
//			String msg = t.getMessage();
//			if (event.detail == SWT.ICON_CANCEL) {
//				System.out.println("Cancel on " + msg);
//			} else if (event.detail == SWT.ICON_SEARCH) {
//				System.out.println("ICON on " + msg);
//			} else {
//				System.out.println("Default selection on " + msg);
//			}
//		};

//		text = new Text(shell, SWT.SEARCH);
//		text.setMessage("search");
//		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//text.addListener(SWT.DefaultSelection, listener);

//		text = new Text(shell, SWT.SEARCH | SWT.ICON_CANCEL);
//		text.setMessage("search + cancel");
//		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		text.addListener(SWT.DefaultSelection, listener);
//
//		text = new Text(shell, SWT.SEARCH | SWT.ICON_SEARCH);
//		text.setMessage("search + icon");
//		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		text.addListener(SWT.DefaultSelection, listener);
//
		text = new Text(shell, SWT.SEARCH | SWT.ICON_CANCEL | SWT.ICON_SEARCH);
		text.setMessage("search + cancel + icon");
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		text.addListener(SWT.DefaultSelection, listener);

		text.addSelectionListener(new SelectionAdapter() {
			 public void widgetDefaultSelected(SelectionEvent event) {
					if (event.detail == SWT.ICON_CANCEL) {
						System.out.println("Cancel on " + text.getText());
					} else if (event.detail == SWT.ICON_SEARCH) {
						System.out.println("ICON on " + text.getText());
					} else {
						System.out.println("Default selection on " + text.getText());
					}
			 }
			});
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}
}