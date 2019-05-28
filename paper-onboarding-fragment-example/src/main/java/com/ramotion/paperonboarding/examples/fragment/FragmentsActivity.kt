package com.ramotion.paperonboarding.examples.fragment

import android.graphics.Color
import android.os.Bundle

import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener

import java.util.ArrayList

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FragmentsActivity : AppCompatActivity() {

  private var fragmentManager: FragmentManager? = null

  private// prepare data
  val dataForOnboarding: ArrayList<PaperOnboardingPage>
    get() {
      val scr1 = PaperOnboardingPage("Hotels", "All hotels and hostels are sorted by hospitality rating",
          Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key)
      val scr2 = PaperOnboardingPage("Banks", "We carefully verify all banks before add them into the app",
          Color.parseColor("#65B0B4"), R.drawable.banks, R.drawable.wallet)
      val scr3 = PaperOnboardingPage("Stores", "All local stores are categorized for your convenience",
          Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_cart)

      val elements = ArrayList<PaperOnboardingPage>()
      elements.add(scr1)
      elements.add(scr2)
      elements.add(scr3)
      return elements
    }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragments_activity_layout)
    fragmentManager = supportFragmentManager

    val onBoardingFragment = PaperOnboardingFragment.newInstance(dataForOnboarding)

    val fragmentTransaction = fragmentManager!!.beginTransaction()
    fragmentTransaction.add(R.id.fragment_container, onBoardingFragment)
    fragmentTransaction.commit()

    onBoardingFragment.setOnRightOutListener(object : PaperOnboardingOnRightOutListener {
      override fun onRightOut() {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val bf = BlankFragment()
        fragmentTransaction.replace(R.id.fragment_container, bf)
        fragmentTransaction.commit()
      }
    })
  }
}
