package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;

public class TrainControllerImpl implements TrainController {

	public Timer timer = new Timer();
	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	boolean timerOn = false;

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
				System.out.println("this is our very new featureee in or der to generate conflict");
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();

	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
		if (!timerOn) {
			timerOn = true;

			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					followSpeed();
				}
			},0,5*1000);
		}
	}

}
