package com.example.applyviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.applyviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // View Binding 코드
//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

//        리셋 되는 카운터
//        var counter = 100
//        binding.textView.text = counter.toString()
//
//        binding.button.setOnClickListener {
//            counter += 1
//            binding.textView.text = counter.toString()
//        }

//        뷰모델 적용
//        val myViewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        myViewModel.counter = 100
//        binding.textView.text = myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }

//      팩토리 패턴을 통해 ViewModel 초기값 적용
        val myRepositoryImpl = MyRepositoryImpl(10)
        val factory = MyViewModelFactory(10, myRepositoryImpl, this)
//        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        val myViewModel by viewModels<MyViewModel>() { factory }
//        binding.textView.text = myViewModel.counter.toString()

        binding.lifecycleOwner = this
        binding.viewmodel = myViewModel

        binding.button.setOnClickListener{
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//            myViewModel.saveState()
//            myViewModel.liveCounter.value = myViewModel.liveCounter.value?.plus(1)
            myViewModel.increaseCounter()
        }

//        myViewModel.liveCounter.observe(this) { counter ->
//            binding.textView.text = counter.toString()
//        }
        // 라이브 데이터 Observing
//        myViewModel.modifiedCounter.observe(this) { counter ->
//            binding.textView.text = counter.toString()
//        }

//        // 팩토리 패턴을 통해 뷰모델에 초기값 적용
//        val factory = MyViewModelFactory(100, this)
////        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
//        val myViewModel : MyViewModel by viewModels { factory }
//        binding.textView.text = myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            myViewModel.saveState()
//            binding.textView.text = myViewModel.counter.toString()
//        }
    }
}