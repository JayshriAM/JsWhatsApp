<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/myBg"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/background_dark"
    tools:context=".GameActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:text="@string/score"
        android:textColor="@android:color/background_light"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/scoreText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:paddingLeft="5dp"
        android:text="@string/zero"
        android:textColor="@android:color/background_light"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/textView"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView9"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="@string/enterNo"
        android:textColor="@android:color/background_light"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <EditText
        android:id="@+id/enteredNo"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:background="@drawable/answer_box"
        android:ems="10"
        android:gravity="center"
        android:inputType="number"
        android:textColor="@android:color/background_light"
        android:textSize="24sp"
        app:layout_constraintBaseline_toBaselineOf="@+id/goBtn"
        app:layout_constraintEnd_toStartOf="@+id/goBtn"
        app:layout_constraintStart_toStartOf="parent" />

    <TextView
        android:id="@+id/countDown"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:textColor="@android:color/background_light"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/enteredNo" />

    <TextView
        android:id="@+id/question"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:fontFamily="casual"
        android:padding="5dp"
        android:text="@string/question"
        android:textColor="@android:color/background_light"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/countDown" />

    <LinearLayout
        android:id="@+id/btnLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:orientation="horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/question">

        <Button
            android:id="@+id/opt1Btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="10dp"
            android:layout_marginRight="10dp"
            android:layout_weight="1"
            android:background="@android:color/background_light"
            android:textColor="@android:color/background_dark" />

        <Button
            android:id="@+id/opt2Btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="10dp"
            android:layout_weight="1"
            android:background="@android:color/background_light"
            android:textColor="@android:color/background_dark" />

        <Button
            android:id="@+id/opt3Btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="10dp"
            android:layout_weight="1"
            android:background="@android:color/background_light"
            android:textColor="@android:color/background_dark" />
    </LinearLayout>

    <TextView
        android:id="@+id/response"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        a