package com.borjalapa.materialdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class MainActivity extends AppCompatActivity {

    Toolbar tbBarraTareas;
    Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //flechita de ir para atrás en el menu de arriba
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //CAMBIAR EL THEMES.XML Y EL MANIFEST.XML


        tbBarraTareas = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tbBarraTareas);

        //Añadir las cosas en los build.gradle

        //Añadir MaterialDrawer totalmente vacío
        new DrawerBuilder().withActivity(this).build();

        //builder de la cabecera del materialdrawer
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.ic_launcher)
                .addProfiles(
                        new ProfileDrawerItem()
                        .withName("Borja")
                        .withEmail("borjaalafu@gmail.com")
                        .withIcon(getResources().getDrawable(R.mipmap.ic_launcher_round))
                )
                .build();


        //Elementos del materialdrawer
        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(tbBarraTareas)
                .withActionBarDrawerToggle(true)
                .withDrawerGravity(Gravity.START)
                .withSliderBackgroundColor(getResources().getColor(android.R.color.darker_gray))
                .withSelectedItem(2)
                .addDrawerItems(
                    new PrimaryDrawerItem()
                        .withIdentifier(1)
                        .withName("Opcion 1")
                        .withIcon(android.R.drawable.btn_star_big_on),
                    new PrimaryDrawerItem()
                        .withIdentifier(2)
                        .withName("Opcion 2")
                        .withIcon(android.R.drawable.arrow_down_float),
                    new DividerDrawerItem(),
                    new SecondaryDrawerItem()
                        .withIdentifier(3)
                        .withName("Cerrar Menu")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 1: {
                                Toast.makeText(MainActivity.this, "Opcion 1 pulsada", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            case 2: {
                                Toast.makeText(MainActivity.this, "Opcion 2 pulsada", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            case 3: {
                                Toast.makeText(MainActivity.this, "Cerrar Menú", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                        return false;
                    }
                }).build();


    }

    //funcionalidad de la flechita de arriba
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Toast.makeText(getApplicationContext(),"BackPressed",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}