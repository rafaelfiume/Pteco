/*
 * VSobre_Panel.java
 *
 * Created on 17 de Agosto de 2006, 23:30
 */

package org.ptolomeu.gui.help;

import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;

import org.jdesktop.swingx.JXHyperlink;

/**
 * VSobre_Panel display basic informations about the software.
 * 
 * TODO: Substituir BareBonesBrowserLaunch pela Java Desktop API.
 * 
 * @author Rafael Fiume
 */
public final class AboutView extends javax.swing.JPanel {

    public AboutView() {
        super();
        initComponents();
        setLabelsSystemProperties();
        configHyperlinks();
    }

    private void configHyperlinks() {
        hyperlinkR_Developer.setClickedColor(new java.awt.Color(153, 0, 153));
        hyperlinkR_Developer.setUnclickedColor(new java.awt.Color(0, 51, 255));
        hyperlinkR_ProductVersion.setClickedColor(new java.awt.Color(153, 0, 153));
        hyperlinkR_ProductVersion.setUnclickedColor(new java.awt.Color(0, 51, 255));
    }

    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneSobre = new javax.swing.JTabbedPane();
        panelLogo = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        panelDetalhe = new javax.swing.JPanel();
        panelIcon1 = new javax.swing.JPanel();
        labelIcon1 = new javax.swing.JLabel();
        panelProduto = new javax.swing.JPanel();
        panelEsquerda = new javax.swing.JPanel();
        panelPergunta = new javax.swing.JPanel();
        panelResposta = new javax.swing.JPanel();
        hyperlinkR_Developer = new JXHyperlink(new LinkAction("My blog...",
                "http://rafaelfiume.wordpress.com/"));
        hyperlinkR_ProductVersion = new JXHyperlink(new LinkAction("Pteco Project's Page",
                "https://github.com/rafaelfiume/Pteco/"));
        labelR_SO = new javax.swing.JLabel();
        labelR_Java = new javax.swing.JLabel();
        labelR_VM = new javax.swing.JLabel();
        labelR_JavaHome = new javax.swing.JLabel();
        labelR_SystemLocale = new javax.swing.JLabel();

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/org/ptolomeu/gui/resources/modelmat.gif"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(panelLogoLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                panelLogoLayout
                        .createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)));
        panelLogoLayout.setVerticalGroup(panelLogoLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                panelLogoLayout
                        .createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)));

        tabbedPaneSobre.addTab("About", panelLogo);

        labelIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/org/ptolomeu/gui/resources/md1.gif"))); // NOI18N

        javax.swing.GroupLayout panelIcon1Layout = new javax.swing.GroupLayout(panelIcon1);
        panelIcon1.setLayout(panelIcon1Layout);
        panelIcon1Layout.setHorizontalGroup(panelIcon1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(labelIcon1));
        panelIcon1Layout
                .setVerticalGroup(panelIcon1Layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING).addComponent(labelIcon1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                        javax.swing.GroupLayout.PREFERRED_SIZE));

        labelProduto.setFont(new java.awt.Font("Dialog", 1, 18));
        labelProduto.setForeground(new java.awt.Color(0, 0, 204));
        labelProduto.setText("ModelMat - Information");

        javax.swing.GroupLayout panelProdutoLayout = new javax.swing.GroupLayout(panelProduto);
        panelProduto.setLayout(panelProdutoLayout);
        panelProdutoLayout.setHorizontalGroup(panelProdutoLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(labelProduto,
                javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE));
        panelProdutoLayout.setVerticalGroup(panelProdutoLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                panelProdutoLayout
                        .createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(labelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 49,
                                Short.MAX_VALUE)));

        javax.swing.GroupLayout panelEsquerdaLayout = new javax.swing.GroupLayout(panelEsquerda);
        panelEsquerda.setLayout(panelEsquerdaLayout);
        panelEsquerdaLayout.setHorizontalGroup(panelEsquerdaLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE));
        panelEsquerdaLayout.setVerticalGroup(panelEsquerdaLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 272, Short.MAX_VALUE));

        labelP_Desenvolvedor.setText("Developer:");

        labelP_Versao.setText("Product Version:");

        labelP_SO.setText("Operating System:");

        labelP_Java.setText("Java:");

        labelP_VM.setText("VM:");

        labelP_JavaHome.setText("Java Home:");

        labelP_SystemLocale.setText("System locale:");

        javax.swing.GroupLayout panelPerguntaLayout = new javax.swing.GroupLayout(panelPergunta);
        panelPergunta.setLayout(panelPerguntaLayout);
        panelPerguntaLayout
                .setHorizontalGroup(panelPerguntaLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelP_JavaHome, javax.swing.GroupLayout.DEFAULT_SIZE, 166,
                                Short.MAX_VALUE)
                        .addComponent(labelP_SystemLocale, javax.swing.GroupLayout.DEFAULT_SIZE,
                                166, Short.MAX_VALUE)
                        .addComponent(labelP_VM, javax.swing.GroupLayout.DEFAULT_SIZE, 166,
                                Short.MAX_VALUE)
                        .addComponent(labelP_Java, javax.swing.GroupLayout.DEFAULT_SIZE, 166,
                                Short.MAX_VALUE)
                        .addComponent(labelP_SO, javax.swing.GroupLayout.DEFAULT_SIZE, 166,
                                Short.MAX_VALUE)
                        .addComponent(labelP_Versao, javax.swing.GroupLayout.DEFAULT_SIZE, 166,
                                Short.MAX_VALUE)
                        .addComponent(labelP_Desenvolvedor, javax.swing.GroupLayout.DEFAULT_SIZE,
                                166, Short.MAX_VALUE));
        panelPerguntaLayout.setVerticalGroup(panelPerguntaLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                panelPerguntaLayout.createSequentialGroup().addComponent(labelP_Desenvolvedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelP_Versao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelP_SO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelP_Java)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelP_VM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelP_JavaHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelP_SystemLocale).addContainerGap(117, Short.MAX_VALUE)));

        panelPerguntaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {
                labelP_Desenvolvedor, labelP_Java, labelP_JavaHome, labelP_SO, labelP_SystemLocale,
                labelP_VM, labelP_Versao });

        hyperlinkR_Developer.setText("Rafael Fiume");

        hyperlinkR_ProductVersion.setText("ModelMat 0.3.0");

        javax.swing.GroupLayout panelRespostaLayout = new javax.swing.GroupLayout(panelResposta);
        panelResposta.setLayout(panelRespostaLayout);
        panelRespostaLayout
                .setHorizontalGroup(panelRespostaLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelR_SystemLocale, javax.swing.GroupLayout.DEFAULT_SIZE,
                                247, Short.MAX_VALUE)
                        .addComponent(labelR_VM, javax.swing.GroupLayout.DEFAULT_SIZE, 247,
                                Short.MAX_VALUE)
                        .addComponent(labelR_Java, javax.swing.GroupLayout.DEFAULT_SIZE, 247,
                                Short.MAX_VALUE)
                        .addComponent(labelR_SO, javax.swing.GroupLayout.DEFAULT_SIZE, 247,
                                Short.MAX_VALUE)
                        .addComponent(labelR_JavaHome, javax.swing.GroupLayout.DEFAULT_SIZE, 247,
                                Short.MAX_VALUE)
                        .addComponent(hyperlinkR_Developer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                247, Short.MAX_VALUE)
                        .addComponent(hyperlinkR_ProductVersion,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE));
        panelRespostaLayout.setVerticalGroup(panelRespostaLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                panelRespostaLayout
                        .createSequentialGroup()
                        .addComponent(hyperlinkR_Developer, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hyperlinkR_ProductVersion,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelR_SO, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelR_Java, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelR_VM, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelR_JavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelR_SystemLocale, javax.swing.GroupLayout.PREFERRED_SIZE,
                                15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(117, Short.MAX_VALUE)));

        panelRespostaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {
                hyperlinkR_Developer, hyperlinkR_ProductVersion, labelR_Java, labelR_JavaHome,
                labelR_SO, labelR_SystemLocale, labelR_VM });

        javax.swing.GroupLayout panelDetalheLayout = new javax.swing.GroupLayout(panelDetalhe);
        panelDetalhe.setLayout(panelDetalheLayout);
        panelDetalheLayout
                .setHorizontalGroup(panelDetalheLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelDetalheLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                panelDetalheLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(
                                                                panelEsquerda,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                panelIcon1,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))
                                        .addGap(12, 12, 12)
                                        .addGroup(
                                                panelDetalheLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                panelDetalheLayout
                                                                        .createSequentialGroup()
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                panelPergunta,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                panelResposta,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                        .addComponent(
                                                                panelProduto,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))));
        panelDetalheLayout.setVerticalGroup(panelDetalheLayout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                panelDetalheLayout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                                panelDetalheLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelIcon1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelProduto,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(
                                panelDetalheLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelPergunta,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(panelEsquerda,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(panelResposta,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)).addContainerGap()));

        tabbedPaneSobre.addTab("Details", panelDetalhe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(tabbedPaneSobre,
                javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(tabbedPaneSobre,
                javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    private void setLabelsSystemProperties() {

        final StringBuilder so = new StringBuilder(System.getProperty("os.name"))
                .append(" version ").append(System.getProperty("os.version"))
                .append(" running on ").append(System.getProperty("os.arch"));
        labelR_SO.setText(so.toString());

        labelR_Java.setText(System.getProperty("java.version"));

        final StringBuilder vm = new StringBuilder(System.getProperty("java.vm.name")).append(" ")
                .append(System.getProperty("java.vm.version"));
        labelR_VM.setText(vm.toString());

        labelR_JavaHome.setText(System.getProperty("java.home"));

        final Locale localidade = Locale.getDefault();
        final StringBuilder systemLocale = new StringBuilder(localidade.getLanguage()).append("_")
                .append(localidade.getCountry());
        labelR_SystemLocale.setText(systemLocale.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXHyperlink hyperlinkR_Developer;

    private org.jdesktop.swingx.JXHyperlink hyperlinkR_ProductVersion;

    private javax.swing.JLabel labelIcon1;

    private javax.swing.JLabel labelLogo;

    private final javax.swing.JLabel labelP_Desenvolvedor = new javax.swing.JLabel();

    private final javax.swing.JLabel labelP_Java = new javax.swing.JLabel();

    private final javax.swing.JLabel labelP_JavaHome = new javax.swing.JLabel();

    private final javax.swing.JLabel labelP_SO = new javax.swing.JLabel();

    private final javax.swing.JLabel labelP_SystemLocale = new javax.swing.JLabel();

    private final javax.swing.JLabel labelP_VM = new javax.swing.JLabel();

    private final javax.swing.JLabel labelP_Versao = new javax.swing.JLabel();

    private final javax.swing.JLabel labelProduto = new javax.swing.JLabel();

    private javax.swing.JLabel labelR_Java;

    private javax.swing.JLabel labelR_JavaHome;

    private javax.swing.JLabel labelR_SO;

    private javax.swing.JLabel labelR_SystemLocale;

    private javax.swing.JLabel labelR_VM;

    private javax.swing.JPanel panelDetalhe;

    private javax.swing.JPanel panelEsquerda;

    private javax.swing.JPanel panelIcon1;

    private javax.swing.JPanel panelLogo;

    private javax.swing.JPanel panelPergunta;

    private javax.swing.JPanel panelProduto;

    private javax.swing.JPanel panelResposta;

    private javax.swing.JTabbedPane tabbedPaneSobre;
    // End of variables declaration//GEN-END:variables

}

/**
 * @see http://www.samspublishing.com/articles/article.asp?p=598024&seqNum=3&rl=1
 */
class LinkAction extends AbstractAction {

    LinkAction(String linkText, String link) {
        // Save the linkâs text and the actual link for later recall when the
        // user clicks the hyperlink.
        putValue(Action.NAME, linkText);
        putValue(Action.SHORT_DESCRIPTION, link);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = (String) getValue(Action.SHORT_DESCRIPTION);
        // TODO: Substituir BareBones pela Java Desktop API
        BareBonesBrowserLaunch.openURL(link);
    }
}
