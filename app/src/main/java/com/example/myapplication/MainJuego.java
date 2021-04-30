package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.domain.Game;
import com.example.myapplication.domain.GameFactory;
import com.example.myapplication.domain.Status;
import com.example.myapplication.domain.score.ScoreBonusCalculator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class MainJuego extends AppCompatActivity {
    TextView contador;
    boolean hasGanado=false;
    long tiempRest;
    int casoconcreto;
    int marcador;
    int karma=1;
    public ArrayList<ImageView> personas=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallajuego);
        RandomizePeople();

        if (savedInstanceState !=null){
            tiempRest=savedInstanceState.getLong("segundos");
            karma=savedInstanceState.getInt("penalizacion");
            casoconcreto= savedInstanceState.getInt("caso");
            cuentaatras(tiempRest);
        }
        else {
            cuentaatras((long) 20);
        }

    }
    public void RandomizePeople(){
        GridLayout miGrid= (GridLayout) findViewById(R.id.Grid);
        int count=miGrid.getChildCount();
        int number;
        int badSelect;
        Random ran=new Random();
        badSelect=ran.nextInt(6);
        for (int i=0;i<count;i++){
            ImageView hijo=(ImageView) miGrid.getChildAt(i);
            number=ran.nextInt(5-1)+1;
            if(i==badSelect){
                hijo.setImageResource(getImage("mal"+number));
                hijo.setTag("PersonaContagiada"+number);
            }
            else {
                // Good select
                hijo.setImageResource(getImage("bien" + number));
                hijo.setTag("Persona"+number);
            }
            personas.add(hijo);
        }


    }
    public int getImage(String imageName){
        int resourceId=this.getResources().getIdentifier(imageName,"drawable", this.getPackageName());
        return resourceId;

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("segundos",tiempRest);
        outState.putInt("caso",casoconcreto); //revisarlo
        outState.putInt("penalizacionSpam",karma);
    }


    public void onClick(View view) throws JSONException, IOException {
        int miID=view.getId();
        ImageView laImagen=(ImageView) findViewById(miID);
        String indice;
        if(laImagen.getTag().toString().contains("PersonaContagiada")){
            //Corrige la mascarilla de la persona que tiene mal puesta la mascallira
            indice=laImagen.getTag().toString().substring(17);
            laImagen.setImageResource(getImage("bien"+indice));

            Game game = GameFactory.currentGame();
            game.updateStatus(Status.SUCCESS);

            ScoreBonusCalculator bonusCalculator = new ScoreBonusCalculator();
            bonusCalculator.addBonus(game.getScore());

            RandomizePeople();

        }
        else{
            Game game = GameFactory.currentGame();
            game.updateStatus(Status.FAILED);
        }

    }


    public void FuncionIrOpcionesJuego(View view) {
        ImageButton imageButton2 = (ImageButton) findViewById(R.id. imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainJuego.this, MenuPausa.class));
            }
        });
    }

    public void cuentaatras(Long tiemp) {
        //Se trata de un contador simple si se termina el tiempo se acaba el juego
        contador = findViewById(R.id.cuentaAtras);
        final long duracionTotal= tiemp * 1000; //milisegundos
        final long tiempoEntreTicks= 1000; //un segundo
        new CountDownTimer(duracionTotal, tiempoEntreTicks) {
            public void onTick(long milisegHastaFin) {
                long segRest = (milisegHastaFin) /1000;
                tiempRest=segRest;
                contador.setText("Quedan: "+String.valueOf(segRest)+" segundos!!!");
            }

            public void onFinish() {
                //marcador y parte de puntucacion es provisional hasta que se haga la base de datos
                marcador=GameFactory.currentGame().getScore().getPoints();

                karma=1;
                contador.setText("Puntuación: "+ marcador);
                /*if(tiempRest==0 && hasGanado==false){
                    startActivity(new Intent(MainJuego.this, PantallaDerrota.class));
                }
                //Te mostraría una pantalla que pone has perdido, con la opción de volver a jugar o salir de la app*/
                karma=0;

                try {
                    serializarPuntuacion();
                } catch (JSONException e) {

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent i=new Intent(MainJuego.this, GameEndedActivity.class);
                startActivity(i);

            }
        }.start();
    }
    public void serializarPuntuacion() throws JSONException, IOException {
        PuntuacionDB lasPuntuaciones=new PuntuacionDB();
        lasPuntuaciones.setPuntuacionReciente(GameFactory.currentGame().getScore().getPoints());
        File testFile= new File(getFilesDir(),"json.txt");
        try {
            FileWriter writer= new FileWriter(testFile);
            JSONObject jo = new JSONObject();
            jo.put("puntuacionReciente",lasPuntuaciones.getPuntuacionReciente());
            writer.write(jo.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void redirigir() {
        //Se trata de un contador simple si se termina el tiempo se acaba el juego
        final long duracionTotal= 3 * 1000; //milisegundos
        final long tiempoEntreTicks= 1000; //un segundo
        new CountDownTimer(duracionTotal, tiempoEntreTicks) {
            public void onTick(long milisegHastaFin) {
                long segRest = (milisegHastaFin) /1000;
                tiempRest=segRest;
            }

            public void onFinish() {


            }
        }.start();
    }

}
