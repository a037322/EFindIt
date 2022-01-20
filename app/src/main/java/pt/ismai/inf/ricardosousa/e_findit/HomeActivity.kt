package pt.ismai.inf.ricardosousa.e_findit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val veiculoFragment = VeiculoFragment()
    private val fornecedorFragment = FornecedorFragment()
    //private val mapFragment = MapFragment()
    private val adicionarFragment = AdicionarFragment()
    private val guardadosFragment = GuardadosFragment()

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        //replaceFragment(mapFragment)

        mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_map_container) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
        })

        bottom_navigation_bar?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_map -> {
                    replaceFragment(mapFragment)
                }
                R.id.nav_veiculo -> {
                    replaceFragment(veiculoFragment)
                }
                R.id.nav_fornecedor -> {
                    replaceFragment(fornecedorFragment)
                }
                R.id.nav_add_location -> {
                    replaceFragment(adicionarFragment)
                }
                R.id.nav_bookmarks -> {
                    replaceFragment(guardadosFragment)
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transation = supportFragmentManager.beginTransaction()
            transation.replace(R.id.fragment_container, fragment)
            transation.commit()
        }
    }
}