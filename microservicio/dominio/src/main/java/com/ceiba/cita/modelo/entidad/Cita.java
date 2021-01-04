package com.ceiba.cita.modelo.entidad;

import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.modelo.entidad.Usuario;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class Cita {

    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_SERVICIO = "Se debe ingresar el id de la cita";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_SERVICIO = "Se debe ingresar el nombre de servicio";
    private static final String SE_DEBE_INGRESAR_EL_IDPROFESIONAL = "Se debe ingresar el id del profesional";
    private static final String SE_DEBE_INGRESAR_EL_SERVICIOSPA = "Se debe ingresar el servicio spa";
    private Long id;
    private Usuario usuario;
    private Long idProfesional;
    private LocalDateTime fecha;
    private Long precio;
    private ServicioSpa servicioSpa;
    private int year;
    private int mesDePascua;
    private int diaDePascua;
    private ArrayList<String> diasFestivos;

    public Cita(Long id, Usuario usuario, Long idProfesional, Long precio, ServicioSpa servicioSpa) {
        validarObligatorio(id, SE_DEBE_INGRESAR_EL_NOMBRE_DE_SERVICIO);
        validarObligatorio(usuario, SE_DEBE_INGRESAR_LA_CLAVE);
        validarObligatorio(idProfesional, SE_DEBE_INGRESAR_EL_IDPROFESIONAL);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DEL_SERVICIO);
        validarObligatorio(servicioSpa, SE_DEBE_INGRESAR_EL_SERVICIOSPA);

        this.id = id;
        this.usuario = usuario;
        this.idProfesional = idProfesional;
        this.precio = precio;
        this.servicioSpa = servicioSpa;
    }

    public Cita(Long id, Usuario usuario, Long idProfesional, LocalDateTime fecha, Long precio, ServicioSpa servicioSpa) {
        this.id = id;
        this.usuario = usuario;
        this.idProfesional = idProfesional;
        this.fecha = fecha;
        this.precio = precio;
        this.servicioSpa = servicioSpa;
    }

    public Cita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public ServicioSpa getServicioSpa() {
        return servicioSpa;
    }

    public void setServicioSpa(ServicioSpa servicioSpa) {
        this.servicioSpa = servicioSpa;
    }

    public LocalDateTime determinarDiaDeLaCita(LocalDateTime fecha) {
        Integer contadorDias = 0;

        while (contadorDias < 2) {
            if (!esDiaSabadoODomingo(fecha)){
                contadorDias++;
            }
            fecha = fecha.plusDays(1);
        }
        this.setFecha(fecha);
        return fecha;
    }

    public void determinarPrecioDeLaCita(){
        int year = LocalDateTime.now().getYear();
        this.determinarFestivos(year);
        if(esFestivo(this.getFecha())){
            this.setPrecio(this.getPrecio() * 2);
        }else {
            this.setPrecio(this.getPrecio());
        }
    }

    public boolean esDiaSabadoODomingo(LocalDateTime fecha) {
        if (fecha.getDayOfWeek() !=DayOfWeek.SATURDAY
                && fecha.getDayOfWeek() != DayOfWeek.SUNDAY) {
            return false;
        }
        return true;
    }

    public boolean esFestivo(LocalDateTime fecha) {
        return this.diasFestivos.contains(fecha.getMonth().ordinal()+":"+fecha.getDayOfMonth());
    }

    public ArrayList<String> determinarFestivos(int year) {
        this.year = year;
        this.diasFestivos = new ArrayList<>();
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        this.mesDePascua = (h - m + r + 90) / 25;
        this.diaDePascua = (h - m + r + this.mesDePascua + 19) % 32;
        this.mesDePascua--;
        this.diasFestivos.add("0:1");               // Primero de Enero
        this.diasFestivos.add("4:1");               // Dia del trabajo 1 de mayo
        this.diasFestivos.add("6:20");              //Independencia 20 de Julio
        this.diasFestivos.add("7:7");               //Batalla de boyaca 7 de agosto
        this.diasFestivos.add("11:8");              //Maria inmaculada 8 de diciembre
        this.diasFestivos.add("11:25");             //Navidad 25 de diciembre
        this.calculoEmiliani(0, 6);           // Reyes magos 6 de enero
        this.calculoEmiliani(2, 19);          //San jose 19 de marzo
        this.calculoEmiliani(5, 29);          //San pedro y san pablo 29 de junio
        this.calculoEmiliani(7, 15);          //Asuncion 15 de agosto
        this.calculoEmiliani(9, 12);          //Descubrimiento de america 12 de octubre
        this.calculoEmiliani(10, 1);          //Todos los santos 1 de noviembre
        this.calculoEmiliani(10, 11);         //Independencia de cartagena 11 de noviembre
        this.calculoOtherHoliday(-3, false);  //jueves santos
        this.calculoOtherHoliday(-2, false);  //viernes santo
        this.calculoOtherHoliday(40, true);   //Asención del señor de pascua
        this.calculoOtherHoliday(60, true);   //Corpus cristi
        this.calculoOtherHoliday(68, true);   //Sagrado corazon

        return this.diasFestivos;
    }

    /**
     * Mueve el dia festivo a lunes por la ley emiliani
     *
     * @param mes Original month of the holiday
     * @param dia   Original day of the holiday
     */
    private void calculoEmiliani(int mes, int dia) {
        Calendar date = Calendar.getInstance();
        date.set(this.year, mes, dia);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                date.add(Calendar.DATE, 1);
                break;
            case 3:
                date.add(Calendar.DATE, 6);
                break;
            case 4:
                date.add(Calendar.DATE, 5);
                break;
            case 5:
                date.add(Calendar.DATE, 4);
                break;
            case 6:
                date.add(Calendar.DATE, 3);
                break;
            case 7:
                date.add(Calendar.DATE, 2);
                break;
            default:
                break;
        }
        this.diasFestivos.add(date.get(Calendar.MONTH) + ":" + date.get(Calendar.DATE));
    }

    /**
     *
     * Calcula los dias festivos segun el dia de pascua
     *
     * @param dias Número de días después (+) o antes (-) del día de pascua
     * @param emiliani Indica si la ley emiliani cumple
     */
    private void calculoOtherHoliday(int dias, boolean emiliani) {
        Calendar date = Calendar.getInstance();
        date.set(this.year, this.mesDePascua, this.diaDePascua);
        date.add(Calendar.DATE, dias);
        if (emiliani) {
            this.calculoEmiliani(date.get(Calendar.MONTH), date.get(Calendar.DATE));
        } else {
            this.diasFestivos.add(date.get(Calendar.MONTH) + ":" + date.get(Calendar.DATE));
        }
    }
}
