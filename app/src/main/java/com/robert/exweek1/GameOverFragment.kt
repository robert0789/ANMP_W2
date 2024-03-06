package com.robert.exweek1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.robert.exweek1.databinding.FragmentGameBinding
import com.robert.exweek1.databinding.FragmentGameOverBinding


class GameOverFragment : Fragment() {
    private lateinit var binding : FragmentGameOverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameOverBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score = GameOverFragmentArgs.fromBundle(requireArguments()).score

        binding.txtScore.text = "Your Score is $score"
        binding.btnBack.setOnClickListener{
            val action = GameOverFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
}
