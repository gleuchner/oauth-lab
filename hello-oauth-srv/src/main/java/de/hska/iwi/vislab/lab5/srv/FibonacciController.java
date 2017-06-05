package de.hska.iwi.vislab.lab5.srv;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@EnableResourceServer
@RestController
public class FibonacciController {

	private AtomicLong sequenceNumber = new AtomicLong(0);

	@RequestMapping(path = "/fibonacci", method = RequestMethod.PUT)
	public ResponseEntity<String> setSequenceNumber(@RequestBody Long seq) {
		if (seq >= 0) {
			sequenceNumber.set(seq);
			return new ResponseEntity<>(sequenceNumber + ":" + getFibonacci(sequenceNumber.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>("0", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(path = "/fibonacci", method = RequestMethod.GET)
	public ResponseEntity<String> getSequenceNumber() {
		return new ResponseEntity<>(sequenceNumber + ":" + getFibonacci(sequenceNumber.get()), HttpStatus.OK);
	}

	@RequestMapping(path = "/fibonacci", method = RequestMethod.DELETE)
	public ResponseEntity<String> resetSequenceNumber() {
		sequenceNumber.set(0);
		return new ResponseEntity<>(sequenceNumber + ":" + getFibonacci(sequenceNumber.get()), HttpStatus.OK);
	}

	private long getFibonacci(long sequence) {
		if (sequence > 1) {
			return getFibonacci(sequence - 2) + getFibonacci(sequence - 1);
		} else {
			if (sequence == 0) {
				return 1;
			} else if (sequence == 1) {
				return 1;
			}
		}
		return 0;
	}
}
