import numpy as np
import skfuzzy as fuzz
from skfuzzy import control as ctrl

# Variables de entrada
velocidad = ctrl.Antecedent(np.arange(0, 101, 1), 'velocidad')
densidad = ctrl.Antecedent(np.arange(0, 61, 1), 'densidad')

# Variable de salida
tiempo_semaforo = ctrl.Consequent(np.arange(0, 61, 1), 'tiempo_semaforo')

# Conjuntos difusos para velocidad del tráfico
velocidad['baja'] = fuzz.trimf(velocidad.universe, [0, 0, 40])
velocidad['media'] = fuzz.trapmf(velocidad.universe, [30, 50, 60, 80])
velocidad['alta'] = fuzz.trimf(velocidad.universe, [70, 90, 100])

# Conjuntos difusos para densidad del tráfico
densidad['baja'] = fuzz.trimf(densidad.universe, [0, 0, 20])
densidad['media'] = fuzz.trapmf(densidad.universe, [15, 25, 35, 45])
densidad['alta'] = fuzz.trimf(densidad.universe, [40, 50, 60])

# Conjuntos difusos para tiempo de duración del semáforo
tiempo_semaforo['corto'] = fuzz.trimf(tiempo_semaforo.universe, [0, 0, 20])
tiempo_semaforo['medio'] = fuzz.trapmf(tiempo_semaforo.universe, [15, 25, 35, 45])
tiempo_semaforo['largo'] = fuzz.trimf(tiempo_semaforo.universe, [40, 50, 60])

# Reglas difusas
regla1 = ctrl.Rule(velocidad['baja'] & densidad['baja'], tiempo_semaforo['corto'])
regla2 = ctrl.Rule(velocidad['media'] & densidad['baja'], tiempo_semaforo['medio'])
regla3 = ctrl.Rule(velocidad['alta'] & densidad['baja'], tiempo_semaforo['largo'])
regla4 = ctrl.Rule(velocidad['baja'] & densidad['media'], tiempo_semaforo['medio'])
regla5 = ctrl.Rule(velocidad['media'] & densidad['media'], tiempo_semaforo['medio'])
regla6 = ctrl.Rule(velocidad['alta'] & densidad['media'], tiempo_semaforo['largo'])
regla7 = ctrl.Rule(velocidad['baja'] & densidad['alta'], tiempo_semaforo['largo'])
regla8 = ctrl.Rule(velocidad['media'] & densidad['alta'], tiempo_semaforo['largo'])
regla9 = ctrl.Rule(velocidad['alta'] & densidad['alta'], tiempo_semaforo['largo'])
regla10 = ctrl.Rule(velocidad['baja'] | densidad['baja'], tiempo_semaforo['corto'])

# Sistema de control difuso
sistema_ctrl = ctrl.ControlSystem([regla1, regla2, regla3, regla4, regla5, regla6, regla7, regla8, regla9, regla10])
sistema = ctrl.ControlSystemSimulation(sistema_ctrl)

# Ejemplo de entrada
sistema.input['velocidad'] = 80
sistema.input['densidad'] = 20

# Evaluación del sistema difuso
sistema.compute()

# Resultado
print("Tiempo de duración del semáforo:", sistema.output['tiempo_semaforo'])
tiempo_semaforo.view(sim=sistema)
