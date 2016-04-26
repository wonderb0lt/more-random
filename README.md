# more-random

This is a simple layer on top of the JDK [`Random`](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
class which provides additional convenience methods, inspired by
[python's random module](https://docs.python.org/2/library/random.html).

## Testing

Testing classes that deal random is always a challenge. The tests for 
this library...

* Rely on the fact that `java.util.Random` does it's job as expected
* Use a seeded delegate for testing (for idempotency)
* Check that the result is within expected parameters without checking for a singular value.
* For edge cases, use a delegate which is biased towards the edge case.
