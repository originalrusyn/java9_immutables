@Value.Style(
    defaults = @Value.Immutable(copy = false),
    strictBuilder = true,
    overshadowImplementation = true,
    implementationNestedInBuilder = true
)
package p;

import org.immutables.value.Value;