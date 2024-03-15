from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection()


package = 'com.bradteachescode.basiccalculator'
activity = '.MainActivity'
runComponent = package + '/' + activity

device.startActivity(component=runComponent)

# Short delay to allow the app to load
MonkeyRunner.sleep(1)


# Taps the digit '5'
device.touch(540, 1200, MonkeyDevice.DOWN_AND_UP) 
MonkeyRunner.sleep(1)

# Taps the '+' button
device.touch(800, 1400, MonkeyDevice.DOWN_AND_UP) 
MonkeyRunner.sleep(1)

# Taps the digit '3'
device.touch(540, 1600, MonkeyDevice.DOWN_AND_UP) 
MonkeyRunner.sleep(1)

# Taps the '=' button
device.touch(800, 1700, MonkeyDevice.DOWN_AND_UP) 
MonkeyRunner.sleep(1)


