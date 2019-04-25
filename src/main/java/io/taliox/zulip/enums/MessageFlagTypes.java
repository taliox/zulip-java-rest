package io.taliox.zulip.enums;

/**
 * The Enum MessageFlagsTypes.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/update-message-flags">https://zulipchat.com/api/update-message-flags</a>
 */
public enum MessageFlagTypes {

	/** The read. */
	read,
	/** The starred. */
	starred,
	/** The collapsed. */
	collapsed,
	/** The mentioned. */
	mentioned,
	/** The wildcard mentioned. */
	wildcard_mentioned,
	/** The summarize in home. */
	summarize_in_home,
	/** The summarize in stream. */
	summarize_in_stream,
	/** The force expand. */
	force_expand,
	/** The force collapse. */
	force_collapse,
	/** The has alert word. */
	has_alert_word,
	/** The historical. */
	historical

}
