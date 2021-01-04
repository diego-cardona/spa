select  cita.*, usuario.*, serviciospa.*
from cita as cita INNER JOIN usuario as usuario
ON cita.id = usuario.id

INNER JOIN serviciospa as serviciospa
ON cita.id = serviciospa.id



