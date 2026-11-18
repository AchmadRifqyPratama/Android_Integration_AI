# Android Integration AI (MBKM Wearable AI)

Android Studio experiments made during the **MBKM (Merdeka Belajar Kampus Merdeka)** *Wearable AI* program, exploring how to run AI / signal-processing models directly on an Android phone:

1. running **Python** code inside an Android app (Chaquopy),
2. running a **TensorFlow Lite RNN-LSTM** model for Human Activity Recognition (HAR) on the phone's accelerometer, and
3. running a **Python heart-rate (HR) estimation pipeline** on recorded wearable PPG/accelerometer data.

All projects live in the `MBKM Wearable AI/` folder; each sub-folder is a standalone Android Studio project (open it individually).

| Project | What it does | Key tech |
|---|---|---|
| [`Python_to_AndroidStudio`](MBKM%20Wearable%20AI/Python_to_AndroidStudio) | Minimal "hello world": starts the Python runtime and shows the string returned by `helloworld.main()` in a `TextView`. | Chaquopy |
| [`HAR_LSTM_AndroidSensor`](MBKM%20Wearable%20AI/HAR_LSTM_AndroidSensor) | Reads the phone's built-in accelerometer, buffers 125 samples (3 axes) and runs `model_HAR_RNNLSTM.tflite`, showing probabilities for Walking, Upstairs, Downstairs, Sitting, Standing and Running. | TensorFlow Lite, Android `SensorManager` |
| [`HAR_LSTM_App`](MBKM%20Wearable%20AI/HAR_LSTM_App) | Runs the HR estimation algorithm in Python (`helloworld.py`) over the bundled `WESAD_S3.csv` recording (PPG ×2 + accelerometer X/Y/Z, 25 Hz) in 8 s windows with a 2 s step, and displays the estimated heart rate. A TFLite model file is also bundled in `app/src/main/ml/`. | Chaquopy, numpy, scipy, pandas |

## How they fit together

- `Python_to_AndroidStudio` is the first step: proving that Python code can be called from Java via Chaquopy (`Python.getInstance().getModule(...).callAttr(...)`).
- `HAR_LSTM_App` builds on that to run a real signal-processing pipeline in Python: Hankel-matrix + SVD decomposition to remove accelerometer-correlated motion artifacts from the PPG, FFT spectral-peak search (60–180 BPM), and a Kalman filter that fuses the two PPG channels into one HR estimate.
- `HAR_LSTM_AndroidSensor` covers the activity-recognition side, running an RNN-LSTM model natively with TensorFlow Lite on live sensor data.

These pieces were later combined into a complete wearable app (Bluetooth PPG/accelerometer streaming + HR estimation + HAR) in the separate repository
[Wearable-HR-Monitoring-System-with-HAR-in-Android-App](https://github.com/AchmadRifqyPratama/Wearable-HR-Monitoring-System-with-HAR-in-Android-App).

## Tech stack

- Java, Android SDK (compileSdk/targetSdk 30), AndroidX, Material Components
- Android Gradle Plugin 7.0.0, Gradle wrapper per project
- Chaquopy 10.0.1 (Python in Android)
- TensorFlow Lite (`tensorflow-lite`, `tensorflow-lite-support`)

## Build & run

1. In Android Studio, open one sub-project folder, e.g. `MBKM Wearable AI/HAR_LSTM_AndroidSensor` (not the repository root).
2. Each project uses the Chaquopy plugin, which needs a local Python to build. Edit
   `python { buildPython "..." }` in that project's `app/build.gradle` to point to your own Python executable (it is currently set to a path on the author's machine).
3. Check `ndk { abiFilters ... }` in `app/build.gradle`: `HAR_LSTM_AndroidSensor` only targets `armeabi-v7a` (physical ARM device); the other two also include `x86` for emulators.
4. Build and run from Android Studio, or:

```bash
cd "MBKM Wearable AI/HAR_LSTM_AndroidSensor"
./gradlew assembleDebug
```

> Note: on Windows, the deep folder names can exceed the default path length limit. If cloning fails with "Filename too long", run `git config --global core.longpaths true` and clone again.

## Data

`HAR_LSTM_App/app/src/main/python/WESAD_S3.csv` is a recording of subject S3 from the [WESAD](https://archive.ics.uci.edu/dataset/465/wesad+wearable+stress+and+affect+detection) dataset, used as offline input for the HR estimation.
