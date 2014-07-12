package com.cxy.redisclient.presentation.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class RedisClientDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	protected Image image;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public RedisClientDialog(Shell parent, Image image) {
		super(parent, SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		this.image = image;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		shell = new Shell(getParent(), getStyle());
		shell.setImage(image);
		
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	protected void createContents() {
		Rectangle screenSize = shell.getParent().getBounds();
		Rectangle shellSize = shell.getBounds();
		shell.setLocation(screenSize.x + screenSize.width / 2 - shellSize.width / 2,
				screenSize.y + screenSize.height / 2 - shellSize.height / 2);
	}

}