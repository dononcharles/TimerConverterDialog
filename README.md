![](https://jitpack.io/v/dononcharles/TimerCustomDialog.svg)  
(https://jitpack.io/#dononcharles/TimerCustomDialog

# TimerCustomDialog
Timer custom dialog is a second converter tool. It converts hours, minutes and seconds into seconds.

# How to use
* Add dependency
```
allprojects {
  repositories {
      maven { url 'https://jitpack.io' }
  }
}
```
```
 implementation 'com.github.dononcharles:TimerCustomDialog:Tag@aar'
```
* Add TextInputEditText in your layout file
```
<com.google.android.material.textfield.TextInputLayout
            android:id="@+id/secondTimerTil"
            style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.Dense"
            android:layout_width="250dp"
            android:layout_height="0dp"
            android:layout_gravity="center"
            android:layout_margin="16dp"
            android:layout_weight="1">

            <com.google.android.material.textfield.TextInputEditText
                android:id="@+id/secondTimerTiet"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.Dense"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:focusable="false"
                android:hint="@string/timer_in_second"
                android:imeOptions="actionNext"
                android:inputType="number" />

        </com.google.android.material.textfield.TextInputLayout>
```
* In your activity class
```
val secondField = findViewById<TextInputEditText>(R.id.secondTimerTiet)
        secondField.apply {
            setOnClickListener {
                STimerDialog(this@MainActivity).customTimerSet(presetInputValue = this.text.toString().toIntOrZero()) { hInSecond, mInSecond, second ->
                    this.setText((hInSecond + mInSecond + second).toString())
                }
            }
        }
```

### See "app" folder for usage

# DEMO
<img src="https://github.com/dononcharles/TimerCustomDialog/blob/master/snapshot.gif" width="350" height="768"/>