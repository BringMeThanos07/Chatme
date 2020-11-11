package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tictocgame.*


class tictocgame : AppCompatActivity(), View.OnClickListener {
    var playX=true
    var TURN_COUNT=0
    var boardstatus=Array(3){IntArray(3)}
    var ply1:String=""
    var ply2:String=""

    lateinit var board:Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        ply1= intent.getStringExtra(KEY_1).toString()
         ply2=intent.getStringExtra(KEY_2).toString()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictocgame)

        board= arrayOf(
            arrayOf(button, button2, button3),
            arrayOf(button4, button5, button6),
            arrayOf(button7, button8, button9)
        )
        for (i in board){
            for (button in i){
                button.setOnClickListener(this)
            }
        }


        initializeBoardStatus()

        resetButton.setOnClickListener {
            playX=true
            TURN_COUNT=0
            displayTv.text="Player ${ply1} Turn"
            initializeBoardStatus()
        }
        back.setOnClickListener {
             val inte=Intent(this, MainActivity::class.java)
            startActivity(inte)
        }
    }

    private fun initializeBoardStatus() {
        for (i in 0..2){
            for (j in 0..2){
                boardstatus[i][j]=-1
                board[i][j].isEnabled=true
                board[i][j].text=""

            }
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.button -> {
                updateValue(row = 0, col = 0, player = playX)
            }
            R.id.button2 -> {
                updateValue(row = 0, col = 1, player = playX)
            }
            R.id.button3 -> {
                updateValue(row = 0, col = 2, player = playX)
            }
            R.id.button4 -> {
                updateValue(row = 1, col = 0, player = playX)
            }
            R.id.button5 -> {
                updateValue(row = 1, col = 1, player = playX)
            }
            R.id.button6 -> {
                updateValue(row = 1, col = 2, player = playX)
            }
            R.id.button7 -> {
                updateValue(row = 2, col = 0, player = playX)
            }
            R.id.button8 -> {
                updateValue(row = 2, col = 1, player = playX)
            }
            R.id.button9 -> {
                updateValue(row = 2, col = 2, player = playX)
            }
        }
        TURN_COUNT++
        playX=!playX
        if (playX)
            updateDisplay("Player X Turn")
        else
            updateDisplay("Player O Turn")

        if (TURN_COUNT==9)
            updateDisplay("Game Draw")

        checkWinner()

    }

    private fun checkWinner() {
        //horizontal row
        for (i in 0..2){
            if (boardstatus[i][0]==boardstatus[i][1]&&boardstatus[i][0]==boardstatus[i][2])
                if (boardstatus[i][0]==1){
                    updateDisplay("Player X is the winner")
                    break
                }
                else if(boardstatus[i][0]==0) {
                    updateDisplay("Player O is the winner")
                    break
                }
        }
        for (i in 0..2){
            if (boardstatus[0][i]==boardstatus[1][i]&&boardstatus[0][i]==boardstatus[2][i])
                if (boardstatus[0][i]==1){
                    updateDisplay("Player X is the winner")
                    break
                }
                else if(boardstatus[0][i]==0) {
                    updateDisplay("Player O is the winner")
                    break
                }
        }
        if (boardstatus[0][0]==boardstatus[1][1]&&boardstatus[0][0]==boardstatus[2][2]){
            if (boardstatus[0][0]==1){
                updateDisplay("Player X is the winner")
            }
            else if(boardstatus[0][0]==0) {
                updateDisplay("Player O is the winner")
            }
        }
        if (boardstatus[0][2]==boardstatus[1][1]&&boardstatus[0][2]==boardstatus[2][0]){
            if (boardstatus[0][2]==1){
                updateDisplay("Player X is the winner")
            }
            else if(boardstatus[0][2]==0) {
                updateDisplay("Player O is the winner")
            }
        }
    }

    private fun updateDisplay(s: String) {
        var w:String=""
        if (s.contains("X")) {
            w =s.replace("X", ply1, false)
        }
        else if (s.contains("O"))
           w = s.replace("O", ply2, false)

        displayTv.text=w

        if (s.contains("winner"))
            disableButton()
    }

    private fun disableButton() {
        for (i in board){
            for (button in i){
                button.isEnabled=false
            }
        }
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val text=if (player) "X" else "O"
        val value=if (player) 1 else 0
        board[row][col].apply {
            isEnabled=false
            setText(text)
        }
        boardstatus[row][col]=value
    }
}