package com.fatimah.responsi1mobile

import android.graphics.text.LineBreaker
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import com.fatimah.responsi1mobile.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.tvHistoryContent.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }
        binding.tvHistoryContent.text = getRealMadridHistoryText()
    }

    private fun getRealMadridHistoryText(): String {
        val indent = "        "
        return """
        ${indent}Real Madrid Club de Fútbol, didirikan pada 6 Maret 1902 sebagai Madrid Football Club, adalah salah satu klub paling ikonik dan sukses dalam sejarah sepak bola dunia. Perjalanan klub ini adalah kisah tentang ambisi, dominasi, dan warisan yang tak tertandingi.

        ${indent}Awal Mula dan Dominasi Domestik Awal
        Klub ini dengan cepat menjadi kekuatan dominan di sepak bola Spanyol. Hanya tiga tahun setelah didirikan, Madrid FC memenangkan gelar pertama mereka, Copa del Rey, pada tahun 1905 dan berhasil mempertahankannya selama tiga tahun berturut-turut. Pada tahun 1920, Raja Alfonso XIII memberikan gelar "Real" (yang berarti "Royal") kepada klub, dan sejak saat itu, mahkota di lambang mereka menjadi simbol kebesaran. Ketika La Liga dibentuk pada tahun 1929, Real Madrid adalah salah satu anggota pendirinya dan memenangkan gelar liga pertama mereka pada musim 1931-1932 tanpa terkalahkan.

        ${indent}Era Emas Santiago Bernabéu dan Kejayaan Eropa
        Transformasi terbesar Real Madrid terjadi di bawah kepemimpinan visioner Santiago Bernabéu Yeste, yang menjabat sebagai presiden dari tahun 1943 hingga 1978. Bernabéu tidak hanya membangun kembali klub setelah Perang Saudara Spanyol, tetapi juga membangun stadion megah yang kemudian dinamai menurut namanya. Visinya yang paling berpengaruh adalah pembentukan Piala Eropa (sekarang Liga Champions UEFA).

        ${indent}Dipimpin oleh pemain legendaris seperti Alfredo Di Stéfano, Ferenc Puskás, Francisco Gento, dan Raymond Kopa, Real Madrid mendominasi edisi-edisi awal turnamen tersebut. Mereka memenangkan lima Piala Eropa pertama secara beruntun dari tahun 1956 hingga 1960, sebuah prestasi yang belum pernah terulang. Kemenangan 7-3 mereka atas Eintracht Frankfurt di final 1960 dianggap oleh banyak orang sebagai salah satu pertandingan sepak bola terhebat yang pernah dimainkan. Era ini mengukuhkan status Real Madrid sebagai "Raja Eropa".

        ${indent}Generasi "Ye-yé" dan Kesuksesan Berkelanjutan
        Setelah generasi emas pertama, Madrid membangun tim baru yang seluruhnya terdiri dari pemain Spanyol, yang dikenal sebagai "Generasi Ye-yé". Tim ini berhasil memenangkan Piala Eropa keenam pada tahun 1966 dan terus mendominasi La Liga sepanjang dekade 1960-an dan 1970-an.

        ${indent}Quinta del Buitre hingga Era Galácticos
        Pada tahun 1980-an, klub ini melihat munculnya generasi pemain akademi yang brilian yang dikenal sebagai "La Quinta del Buitre" (Angkatan Burung Nazar), yang dipimpin oleh Emilio Butragueño. Mereka membawa Real Madrid meraih lima gelar La Liga berturut-turut (1986–1990) dan dua Piala UEFA.

        ${indent}Awal milenium baru menandai dimulainya era "Galácticos" di bawah presiden Florentino Pérez. Kebijakannya adalah merekrut satu superstar global setiap musim panas. Era ini dihiasi oleh pemain-pemain seperti Luís Figo, Zinedine Zidane, Ronaldo Nazário, dan David Beckham. Puncak dari era ini adalah gol voli ikonik Zidane di final Liga Champions 2002 yang mengamankan gelar kesembilan ("La Novena").

        ${indent}Dominasi Modern di Liga Champions
        Setelah beberapa tahun tanpa gelar Eropa, Real Madrid kembali menaklukkan benua di bawah asuhan Carlo Ancelotti dan kemudian Zinedine Zidane. Dipimpin oleh Cristiano Ronaldo, pencetak gol terbanyak sepanjang masa klub, Madrid memenangkan empat gelar Liga Champions dalam lima musim, termasuk tiga gelar berturut-turut dari 2016 hingga 2018 ("La Decimotercera"). Prestasi ini sekali lagi menegaskan DNA Eropa klub.

        ${indent}Hingga hari ini, Real Madrid terus menjadi tolok ukur kesuksesan, identik dengan trofi, legenda, dan momen-momen magis yang telah membentuk sejarah sepak bola. Dengan koleksi gelar yang tak terhitung jumlahnya, klub ini tidak hanya mewakili kota Madrid tetapi juga standar keunggulan di panggung dunia. Hala Madrid!
        """.trimIndent()
    }
}