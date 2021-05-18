package sample.assets.components;

import javafx.scene.control.ProgressBar;
import sample.views.Pista;

    public class Runner extends Thread{
        private ProgressBar progressBar;
        public Runner(String nombre, ProgressBar progressBar){
            super(nombre);
            this.progressBar = progressBar;
            //this.setName(nombre);
        }
        /*
            @Override
            public void run() {
                super.run();
                System.out.println("Inicia el corredor "+getName());
                for (int i = 0; i <= 5; i++){
                    System.out.println("Kilometro " +i);
                    try {
                        sleep((long)(Math.random()*10000));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("Runner "+ getName() +" Completo el Kilometro " +i);
                }
                System.out.println("Llego a la meta el corredor "+ getName());
            }*/
        public void run(){
            super.run();
            double avance = 0;
            while (avance < 1){
                avance+= Math.random()/10;//.34/10 ? .034
                this.progressBar.setProgress(avance);
                try {
                    sleep((long)(Math.random()*100000));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
