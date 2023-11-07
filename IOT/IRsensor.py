# import RPi.GPIO as gpio
# import time

# gpio.setmode(gpio.BCM)

# gpio.setup(3,gpio.IN)

# count=0

# while True:
#     state=gpio.input(3)

#     if state==0:
#         count=count+1
#         print("count is",count)
#         time.sleep(0.2)
#     else:
#         continue


import RPi.GPIO as gpio
import time

pin = 5

high = True
low = False


def initSystem():
    gpio.setmode(gpio.BCM)
    gpio.setup(pin, gpio.IN, pull_up_down=gpio.PUD_UP)
    return


def detectPerson():
    while True:
        state = gpio.input(pin)
        time.sleep(0.3)
        if (state == 0):
            return low
        else:
            return high


try:
    initSystem()

    count = 0

    while True:
        state = detectPerson()

        if state == high:
            count += 1
            print("count is:", count)
except KeyboardInterrupt:
    print("keyboard intrupt")

finally:
    gpio.cleanup()

# GPIO.PUD_UP
# An input gpio will float between 0 and 1 if it's not connected to a voltage.

# The pull-up/downs supply that voltage so that the gpio will have a defined value UNTIL overridden by a stronger force.

# You should set a pull-down (to 0) when you expect the stronger force to pull it up to 1.

# You should set a pull-up (to 1) when you expect the stronger force to pull it down to 0.

# Otherwise the gpio will not change state and you'll never know about the external event.
# Pull up / Pull down resistors
# If you do not have the input pin connected to anything, it will 'float'. In other words, the value that is read in is undefined because it is not connected to anything until you press a button or switch. It will probably change value a lot as a result of receiving mains interference.
# To get round this, we use a pull up or a pull down resistor. In this way, the default value of the input can be set. It is possible to have pull up/down resistors in hardware and using software. In hardware, a 10K resistor between the input channel and 3.3V (pull-up) or 0V (pull-down) is commonly used. The RPi.GPIO module allows you to configure the Broadcom SOC to do this in software:
# GPIO.setup(channel, GPIO.IN, pull_up_down=GPIO.PUD_UP)
#   # or
# GPIO.setup(channel, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
# (where channel is the channel number based on the numbering system you have specified - BOARD or BCM).
