package com.robert.exweek1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.robert.exweek1.databinding.FragmentGameBinding
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var binding : FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.setText("$name's Turn")
        }



        var realAnswer = generateQuestion()

        var score = 0

        binding.btnSubmit.setOnClickListener{

            val guessAnswer = binding.txtAnswer.text.toString().trim().toIntOrNull()
            if (guessAnswer != null) {
                if(realAnswer == guessAnswer){
                    score += 1

                    realAnswer = generateQuestion()
                }
                else{
                    val action = GameFragmentDirections.actionGameoverFragment(score)
                    Navigation.findNavController(it).navigate(action)
                }
            } else {
                val toast = Toast.makeText(this.context, "Something Wrong", Toast.LENGTH_SHORT) // in Activity
                toast.show()

            }

        }




    }

    private fun generateQuestion():Int{
        val firstValues =  Random.nextInt(0, 100)
        val secondValues = Random.nextInt(0, 100)

        val question = "${firstValues.toString()} + ${secondValues.toString()}"

        binding.txtQuestion.text = question

        return firstValues + secondValues
    }



}