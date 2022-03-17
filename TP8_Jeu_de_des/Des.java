public class Des {
	
	private int face;

	/**
	 * @param face
	 */
	public Des(int face) {
		this.face = face;
	}

	/**
	 * @return
	 */
	protected int getFace() {
		return face;
	}

	/**
	 * @param face
	 */
	protected void setFace(int face) {
		this.face = face;
	}

	@Override
	public String toString() {
		return "Des [face=" + face + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Des other = (Des) obj;
		return face == other.face;
	}

}
