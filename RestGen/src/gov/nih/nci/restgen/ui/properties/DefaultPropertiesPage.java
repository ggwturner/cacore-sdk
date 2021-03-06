/*L
 *  Copyright Ekagra Software Technologies Ltd.
 *  Copyright SAIC, SAIC-Frederick
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/cacore-sdk/LICENSE.txt for details.
 */

/**
 * The content of this file is subject to the caCore SDK Software License (the "License").  
 * A copy of the License is available at:
 * [caCore SDK CVS home directory]\etc\license\caCore SDK_license.txt. or at:
 * http://ncicb.nci.nih.gov/infrastructure/cacore_overview/caCore SDK/indexContent
 * /docs/caCore SDK_License
 */


package gov.nih.nci.restgen.ui.properties;

import java.awt.Dimension;

import gov.nih.nci.restgen.ui.common.DefaultSettings;
import gov.nih.nci.restgen.ui.mapping.CDEPropertyPanel;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;

/**
 * This class defines the default properties pane view.
 *
 * @author Prakash Vinjamuri
 * @author Prakash Vinjamuri LAST UPDATE $Author:
 * @since     CMTS v1.0
 * @version    $Revision: 1.3 $
 * @date       $Date: 2013-01-11
 */
public class DefaultPropertiesPage extends JSplitPane
{
	private TitledBorder titledBorder = null;
	private PropertiesSwitchController propertiesController;
	private DefaultPropertiesTableModel tableModel;
	private CDEPropertyPanel cdePane;

	/**
	 * Creates a new <code>JPanel</code> with a double buffer
	 * and a flow layout.
	 */
	public DefaultPropertiesPage(PropertiesSwitchController propertiesController)
	{
		super(JSplitPane.VERTICAL_SPLIT);
		this.propertiesController = propertiesController;
		if(propertiesController!=null)
			this.propertiesController.setPropertiesPage(this);
		initialize();
	}

	private void initialize()
	{
        JScrollPane scrollPane = new JScrollPane();
		tableModel = new DefaultPropertiesTableModel(propertiesController);
		JTable propertiesTable = new JTable(tableModel);
		propertiesTable.setShowGrid(true);
		ListSelectionModel tableListSelectionModel = propertiesTable.getSelectionModel();
		tableListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().setView(propertiesTable);
		titledBorder = BorderFactory.createTitledBorder(propertiesController!=null?propertiesController.getTitleOfPropertiesPage():"info");
		setBorder(titledBorder);

		cdePane=new CDEPropertyPanel();
		setTopComponent(cdePane);
		setBottomComponent( scrollPane );
		setPreferredSize(new Dimension(DefaultSettings.FRAME_DEFAULT_WIDTH /4, DefaultSettings.FRAME_DEFAULT_HEIGHT / 10));
		setDividerLocation(0);
	}

	public void updateProptiesDisplay(ChangeEvent e)
	{
		titledBorder.setTitle(propertiesController.getTitleOfPropertiesPage());
		tableModel.setPropertiesResult(propertiesController.getPropertyDescriptors());
		cdePane.updateSelection(propertiesController.getSelectedItem());
        if (!cdePane.doesHaveOwnData())
        {
            setDividerLocation(0);
        }
       
        else setDividerLocation(120);
        this.repaint();
	}
}

/**
 * HISTORY      : $Log: not supported by cvs2svn $
 * HISTORY      : Revision 1.2  2009/10/27 18:23:25  wangeug
 * HISTORY      : hook property panel with tree nodes
 * HISTORY      :
 * HISTORY      : Revision 1.1  2008/12/29 22:18:18  linc
 * HISTORY      : function UI added.
 * HISTORY      :
 */
