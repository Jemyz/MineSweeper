package ms;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sweep extends javax.swing.JFrame {
    
    final int wid = 9, hei = 9, noOfBombs = 10;
    JToggleButton[][] blocks = new JToggleButton[hei][wid];
    int [][] blox = new int [hei][wid];
    boolean first, canPlay;
    
    ActionListener listen = new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           int i = 0 , j = 0;
           boolean found = false;
           for(i = 0; i < hei; i++){
               for(j = 0; j < wid; j++)
               {
                   if(e.getSource() == blocks[i][j]){
                       found = true;
                        break;
                   }
                  
                       
               }
               if(found) break;
           }
           if (canPlay){
            blocks[i][j].setSelected(true);
            if(!first){
               spawn(i, j);
               first = true;
            }
            if(blox[i][j]!= -1 ){
                    open(i,j);
                    reval();
            }else lose();
           checkWin();
           }else reval();
            
       
       }
    };
    
    private void checkWin(){
        boolean won = true;
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == 0) {
                    won = false;
                    break;
                }
            }
            if(!won) break;
        }
        if(won){
            javax.swing.JOptionPane.showMessageDialog(null, "You win!!!");
            canPlay=false;
        }
    }
    
    private void lose (){
        
        canPlay = false;
        
        for(int i = 0; i < hei; i++){
               for(int j = 0; j < wid; j++)
               {
                 if(blox[i][j] == -1){
                   blocks[i][j].setText("BOOM");
                   blocks[i][j].setSelected(true);
                 }
               }
        }       
        
    }
    
     private void open(int y, int x){
        if(y < 0 || x < 0 || x > wid - 1 || y > hei - 1 || blox[y][x] != 0) return;
        int bombs = 0;
        for(int i = y - 1; i <= y + 1;i++){
            for(int j = x - 1; j <= x + 1;j++){
                if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1) && blox[i][j] == -1)
                    bombs++;
            }
        }
        if(bombs == 0){
            blox[y][x] = -2;
            for(int i = y - 1; i <= y + 1;i++){
                for(int j = x - 1; j <= x + 1;j++){
                    if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1))
                    if(i != y || j != x) open(i,j);
                }
            }
        } else blox[y][x] = bombs;
    }
    
    
    private void reval(){
        
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                
                if(blox[i][j] == 0){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(false);
                }
                if(blox[i][j] == -2){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(true);
                }
                if(blox[i][j] > 0){
                    blocks[i][j].setText(""+blox[i][j]);
                    blocks[i][j].setSelected(true);
                }
                if(!canPlay && blox[i][j] == -1) blocks[i][j].setSelected(true);
            }
        }
        
        jPanel1.repaint();
    }
    
    private void spawn(int y, int x){
        
        for(int k = 1; k <= noOfBombs;k++){
            int i, j;
            do{
                i = (int)(Math.random()*(wid-.01));
                j = (int)(Math.random()*(hei-.01));
            }
            while(blox[i][j] == -1 || (i == y && j == x));
            blox[i][j] = -1;
            
        }
    }
    

    
    public Sweep() {
        initComponents();
        for(int i = 0; i < hei; i++){
            for(int j = 0;j < wid; j++){
                blocks[i][j] = new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
                blocks[i][j].addActionListener(listen);
                
            }
        }
        first = false;
        canPlay = true;
    }

    
    private void resiz(){
        
        for(int i = 0; i < hei; i++){
            for(int j = 0;j < wid; j++){
                try {
                     blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
                } catch (Exception e) {
                }
               
                
                
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jMenu1.setText("Game");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("NewGame");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        resiz();
        
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        blox = new int[hei][wid];
        reval();
        canPlay = true;
        first = false;
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sweep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
