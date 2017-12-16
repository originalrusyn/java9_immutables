package p.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Immutable implementation of {@link B}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableB.builder()}.
 */
@SuppressWarnings({"all"})
public final class ImmutableB implements B {
  private final String text;

  private ImmutableB(String text) {
    this.text = text;
  }

  /**
   * @return The value of the {@code text} attribute
   */
  @Override
  public String getText() {
    return text;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link B#getText() text} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for text
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableB withText(String value) {
    if (this.text.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "text");
    return new ImmutableB(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableB} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableB
        && equalTo((ImmutableB) another);
  }

  private boolean equalTo(ImmutableB another) {
    return text.equals(another.text);
  }

  /**
   * Computes a hash code from attributes: {@code text}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + text.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code B} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "B{"
        + "text=" + text
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link B} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable B instance
   */
  public static ImmutableB copyOf(B instance) {
    if (instance instanceof ImmutableB) {
      return (ImmutableB) instance;
    }
    return ImmutableB.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableB ImmutableB}.
   * @return A new ImmutableB builder
   */
  public static ImmutableB.Builder builder() {
    return new ImmutableB.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableB ImmutableB}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TEXT = 0x1L;
    private long initBits = 0x1L;

    private String text;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code B} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(B instance) {
      Objects.requireNonNull(instance, "instance");
      text(instance.getText());
      return this;
    }

    /**
     * Initializes the value for the {@link B#getText() text} attribute.
     * @param text The value for text 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder text(String text) {
      this.text = Objects.requireNonNull(text, "text");
      initBits &= ~INIT_BIT_TEXT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableB ImmutableB}.
     * @return An immutable instance of B
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableB build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableB(text);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_TEXT) != 0) attributes.add("text");
      return "Cannot build B, some of required attributes are not set " + attributes;
    }
  }
}
