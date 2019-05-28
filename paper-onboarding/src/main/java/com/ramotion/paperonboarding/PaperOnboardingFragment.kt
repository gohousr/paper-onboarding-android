package com.ramotion.paperonboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnLeftOutListener
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener

import java.util.ArrayList
import androidx.fragment.app.Fragment

/**
 * Ready to use PaperOnboarding fragment
 */
class PaperOnboardingFragment : Fragment() {

  private var mOnChangeListener: PaperOnboardingOnChangeListener? = null
  private var mOnRightOutListener: PaperOnboardingOnRightOutListener? = null
  private var mOnLeftOutListener: PaperOnboardingOnLeftOutListener? = null
  var elements: ArrayList<PaperOnboardingPage>? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (arguments != null) {
      elements = arguments!!.get(ELEMENTS_PARAM) as ArrayList<PaperOnboardingPage>
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.onboarding_main_layout, container, false)

    // create engine for onboarding element
    val mPaperOnboardingEngine = PaperOnboardingEngine(view.findViewById(R.id.onboardingRootView), elements, activity!!.applicationContext)
    // set listeners
    mPaperOnboardingEngine.setOnChangeListener(mOnChangeListener!!)
    mPaperOnboardingEngine.setOnLeftOutListener(mOnLeftOutListener!!)
    mPaperOnboardingEngine.setOnRightOutListener(mOnRightOutListener!!)

    return view
  }

  fun setOnChangeListener(onChangeListener: PaperOnboardingOnChangeListener) {
    this.mOnChangeListener = onChangeListener
  }

  fun setOnRightOutListener(onRightOutListener: PaperOnboardingOnRightOutListener) {
    this.mOnRightOutListener = onRightOutListener
  }

  fun setOnLeftOutListener(onLeftOutListener: PaperOnboardingOnLeftOutListener) {
    this.mOnLeftOutListener = onLeftOutListener
  }

  companion object {

    private val ELEMENTS_PARAM = "elements"


    fun newInstance(elements: ArrayList<PaperOnboardingPage>): PaperOnboardingFragment {
      val fragment = PaperOnboardingFragment()
      val args = Bundle()
      args.putSerializable(ELEMENTS_PARAM, elements)
      fragment.arguments = args
      return fragment
    }
  }

}
