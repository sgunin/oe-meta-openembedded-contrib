if [ "$ZSH_VERSION" ]; then
	emulate -R zsh
	[ "PS1" = '\u@\h:\w\$ ' ] && PS1='%n@%m:%~%# '
fi
