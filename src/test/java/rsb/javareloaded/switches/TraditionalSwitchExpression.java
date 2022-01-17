package rsb.javareloaded.switches;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TraditionalSwitchExpression {

	@Test
	void switchExpression() {
		Assertions.assertEquals(respondToEmotionalState(Emotion.HAPPY), "that's wonderful.");
		Assertions.assertEquals(respondToEmotionalState(Emotion.SAD), "I'm so sorry to hear that.");
	}

	public String respondToEmotionalState(Emotion emotion) {
		var response = "";
		switch (emotion) {
		case HAPPY:
			response = "that's wonderful.";
			break;
		case SAD:
			response = "I'm so sorry to hear that.";
			break;
		}

		return response;
	}

	enum Emotion {

		HAPPY, SAD

	}

}
