package com.ramotion.paperonboarding

import java.io.Serializable

/**
 * Represents content for one page of Paper Onboarding
 */
class PaperOnboardingPage : Serializable {

  var titleText: String? = null
  var descriptionText: String? = null
  var bgColor: Int = 0
  var contentIconRes: Int = 0
  var bottomBarIconRes: Int = 0

  constructor() {}

  constructor(titleText: String, descriptionText: String, bgColor: Int, contentIconRes: Int, bottomBarIconRes: Int) {
    this.bgColor = bgColor
    this.contentIconRes = contentIconRes
    this.bottomBarIconRes = bottomBarIconRes
    this.descriptionText = descriptionText
    this.titleText = titleText
  }

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false

    val that = o as PaperOnboardingPage?

    if (bgColor != that!!.bgColor) return false
    if (contentIconRes != that.contentIconRes) return false
    if (bottomBarIconRes != that.bottomBarIconRes) return false
    if (if (titleText != null) titleText != that.titleText else that.titleText != null)
      return false
    return if (descriptionText != null) descriptionText == that.descriptionText else that.descriptionText == null

  }

  override fun hashCode(): Int {
    var result = if (titleText != null) titleText!!.hashCode() else 0
    result = 31 * result + if (descriptionText != null) descriptionText!!.hashCode() else 0
    result = 31 * result + bgColor
    result = 31 * result + contentIconRes
    result = 31 * result + bottomBarIconRes
    return result
  }

  override fun toString(): String {
    return "PaperOnboardingPage{" +
        "titleText='" + titleText + '\''.toString() +
        ", descriptionText='" + descriptionText + '\''.toString() +
        ", bgColor=" + bgColor +
        ", contentIconRes=" + contentIconRes +
        ", bottomBarIconRes=" + bottomBarIconRes +
        '}'.toString()
  }
}
