package com.ramotion.paperonboarding.listeners

import android.animation.Animator

/**
 * Just sugar for code clean
 */
abstract class AnimatorEndListener : Animator.AnimatorListener {

  override fun onAnimationStart(animation: Animator) {
    //do nothing
  }

  override fun onAnimationCancel(animation: Animator) {
    //do nothing
  }

  override fun onAnimationRepeat(animation: Animator) {
    //do nothing
  }
}
