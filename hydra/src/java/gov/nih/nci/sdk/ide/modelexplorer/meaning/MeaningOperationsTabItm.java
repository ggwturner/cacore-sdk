package gov.nih.nci.sdk.ide.modelexplorer.meaning;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;

import gov.nih.nci.sdk.ide.core.CategoryTabItem;
import gov.nih.nci.sdk.ide.modelexplorer.Constants;

public class MeaningOperationsTabItm extends CategoryTabItem {

	public MeaningOperationsTabItm(TabFolder parent, int style, Object data) {
		super(parent, style, data, Constants.TAB_Operations);
	}

	@Override
	public void paint() {
		Composite composite = super.getUIComposite();
		composite.setLayout(super.getLayout());
		
		Button button = new Button(composite, SWT.PUSH);
		button.setText("Replace me for " + super.getTitle());
		
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}