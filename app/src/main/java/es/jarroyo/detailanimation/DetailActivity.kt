package es.jarroyo.detailanimation

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.activity_detail_1.*

class DetailActivity : AppCompatActivity() {

    private var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_1)

        activity_detail_iv.setOnClickListener {
            if(show) {
                hideComponents() // if the animation is shown, we hide back the views
            }
            else {
                showComponents() // if the animation is NOT shown, we animate the views
            }
        }
    }

    private fun showComponents(){
        show = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_detail_2)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(activity_detail_constraint_layout, transition)
        constraintSet.applyTo(activity_detail_constraint_layout) //here constraint is the name of view to which we are applying the constraintSet
    }

    private fun hideComponents(){
        show = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_detail_1)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(activity_detail_constraint_layout, transition)
        constraintSet.applyTo(activity_detail_constraint_layout) //here constraint is the name of view to which we are applying the constraintSet
    }
}
