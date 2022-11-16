package com.example.gorselnesneler11listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var ListView:ListView
    lateinit var TvSecilenBolge:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ListView = findViewById(R.id.ListView)
        TvSecilenBolge = findViewById(R.id.TvSecilenBolge)

        val Bolgeler = resources.getStringArray(R.array.Bolgeler)
        /*-> Burada "String.xml" dosyasın'da oluşturduğumuz "Bolgeler"adlı dizi'yi "Bolgeler" adlı değişken'e aktararak
             buradan erişebilinir yaptık yani dahil ettik.      */

        val adapterr = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,Bolgeler)

        ListView.adapter = adapterr // -> Burada ise ".adapter" metod'u ile oluşturduğumuz adaptör'ü (adapterr) "ListView" nesne'sine yerleştirdik.

        ListView.setOnItemClickListener { parent, view, positionYaniIndeks, id -> // Dizi'li nesnelerde bu metot kullanılır.

            Toast.makeText(this@MainActivity,"Tıkladığınız bölge :${Bolgeler[positionYaniIndeks]}",Toast.LENGTH_SHORT).show()

            TvSecilenBolge.text = resources.getString(R.string.SectiginizBolge) + Bolgeler[positionYaniIndeks]
            /*
            "TvSecilenBolge.text = resources.getString(R.string.SectiginizBolge) + Bolgeler[positionYaniIndeks]"
            Burada ListView nesnesi üzerindeki dizi'deki eleman'lardan seçtiğimiz eleman'ı " TvSecilenBolge"
            id 'li TextView 'de yazdırttık.

            " TvSecilenBolge.text" -> TvSecilenBolge id'li TextView üzerinde ".text" metod'u yazdır demek.

             "resources.getString(R.string.SectiginizBolge)" -> TvSecilenBolge id'li TextView'un String.xml
             dosyasına'da eklediğimiz "text" yani yazı kısmı'nda yazan yazıyı String.xml dosyasın'daki hali
             ile "SectiginizBolge" çağırdık.

             " + Bolgeler[positionYaniIndeks]" Ve string.xml den çağırdığımız bu text kısımına uygulama
             çalışırken ListView üzerinde hangi indeks numarasına sahip eleman'ı seçersek text kısmın'da
             onun gözükmesi için olan kod.

             Dizi'li nesnelerde "setOnItemClickListener" veya "setOnItemSelectedListener" kullanılır ancak mutlaka
             her ikisinde'de "parent, view, positionYaniIndeks, id -> " kısmı bulunmak zorunda'dır buradaki
             "positionYaniIndeks" dizi'deki indeks değişkeni olarak kullanılır.

             Not :

             Eğer eşitliğin sağ tarafına "resources.getString(R.string.SectiginizBolge) +" kısımını
             yazmadan sadece " Bolgeler[positionYaniIndeks] " yazsaydık; uygulama çalıştığında
             ListView 'da bir bölge seçtiğimizde TextView 'da sadece seçtiğimiz bölge ismi yazacaktı.
             Örneğin: "Hawai" gibi.

             Ancak "resources.getString(R.string.SectiginizBolge) +" kodu ile birlikte TextView 'da
             şu şekilde gözükecektir; "Seçtiğiniz Bölge: Hawai"

             Ve bu farklı dillere çevirmede'de oldukça önemli'dir çünkü String dosyası üzerinden çağırdık.
             */
        }










    }
}