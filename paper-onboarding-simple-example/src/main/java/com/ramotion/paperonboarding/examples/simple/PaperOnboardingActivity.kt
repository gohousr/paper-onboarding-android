package com.ramotion.paperonboarding.examples.simple

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.ramotion.paperonboarding.PaperOnboardingEngine
import com.ramotion.paperonboarding.PaperOnboardingPage
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener

import java.util.ArrayList

import androidx.appcompat.app.AppCompatActivity

class PaperOnboardingActivity : AppCompatActivity() {

  // Just example data for Onboarding
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
    setContentView(R.layout.onboarding_main_layout)

    val engine = PaperOnboardingEngine(findViewById<View>(R.id.onboardingRootView), dataForOnboarding, applicationContext)

    engine.setOnChangeListener(object : PaperOnboardingOnChangeListener {
      override fun onPageChanged(oldElementIndex: Int, newElementIndex: Int) {
        Toast.makeText(applicationContext, "Swiped from $oldElementIndex to $newElementIndex", Toast.LENGTH_SHORT).show()
      }
    })

    engine.setOnRightOutListener(object : PaperOnboardingOnRightOutListener {
      override fun onRightOut() {
        // Probably here will be your exit action
        Toast.makeText(applicationContext, "Swiped out right", Toast.LENGTH_SHORT).show()
      }
    })

  }
}
