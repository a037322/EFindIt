package pt.ismai.inf.ricardosousa.e_findit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val veiculoFragment = VeiculoFragment()
    private val fornecedorFragment = FornecedorFragment()
    private val mapFragment = MapFragment()
    private val adicionarFragment = AdicionarFragment()
    private val guardadosFragment = GuardadosFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        replaceFragment(mapFragment)
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