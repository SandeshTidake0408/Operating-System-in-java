# import RPi.GPIO as gpio
# import time
# gpio.setmode(GPIO.BOARD)  #--- as board pin

# # gpio.setmode(GPIO.BCM)   #---as gpio pins

# # for output pin
# gpio.setup(3,gpio.OUT)

# # on output pin
# # gpio.output(3,True)   true- on   false-off

# while(True):
#     gpio.output(3,True)
#     time.sleep(1)
#     gpio.output(3,False)
#     time.sleep(1)


import RPi.GPIO as gpio
import time

led1 = 20
led2 = 21
led3 = 22
led4 = 23
led5 = 24
led6 = 25
led7 = 26
led8 = 27

myled = [led1, led2, led3, led4, led5, led6, led7, led8]

gpio.setmode(gpio.BCM)

gpio.setup(led1, gpio.OUT)
gpio.setup(led2, gpio.OUT)
gpio.setup(led3, gpio.OUT)
gpio.setup(led4, gpio.OUT)
gpio.setup(led5, gpio.OUT)
gpio.setup(led6, gpio.OUT)
gpio.setup(led7, gpio.OUT)
gpio.setup(led8, gpio.OUT)


def ledState(led, state):
    gpio.setup(myled[led], state)


try:
    for i in range(0, 8):
        ledState(i, 1)

    while True:
        for i in range(0, 8):
            ledState(i, 1)
            time.sleep(1)
            ledState(i, 0)
            time.sleep(1)
except KeyboardInterrupt:
    # RUNNING=Flase
    print("keyboard interupt")
finally:
    gpio.cleanup()
