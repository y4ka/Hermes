function inputButton(idPylon, idButton)
{
	var test = 'inputButton';
		
	return test;
}

function tick(nbTick)
{
	scenario.getPlayers()[0].setName("TEST"+nbTick);

	return scenario.getPlayers()[0].getName();
}