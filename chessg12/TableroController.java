public boolean jaque() {
        int reyBx = -1;
        int reyBy = -1;
        int reyNx = -1;
        int reyNy = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (b[i][j].getGraphic() != null) {
                    ImageView pieza = (ImageView) b[i][j].getGraphic();

                    if (compImagenes(Modelo.reyB.getImage(), pieza.getImage())) {
                        reyBx = j;
                        reyBy = i;
                    } else if (compImagenes(Modelo.reyN.getImage(), pieza.getImage())) {
                        reyNx = j;
                        reyNy = i;
                    }
                }
            }
        }

        if (reyBx != -1 && reyBy != -1) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (b[i][j].getGraphic() != null) {
                        ImageView pieza = (ImageView) b[i][j].getGraphic();

                        if (!piezaBlanca(pieza) && puedeAtacar(pieza, j, i, reyBx, reyBy)) {
                            return true;
                        }
                    }
                }
            }
        }

        if (reyNx != -1 && reyNy != -1) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (b[i][j].getGraphic() != null) {
                        ImageView pieza = (ImageView) b[i][j].getGraphic();

                        if (piezaBlanca(pieza) && puedeAtacar(pieza, j, i, reyNx, reyNy)) {

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean puedeAtacar(ImageView pieza, int xPieza, int yPieza, int xCasillaObjetivo, int yCasillaObjetivo) {
        if (compImagenes(Modelo.caballoBlanco.getImage(), pieza.getImage()) || compImagenes(Modelo.caballoNegro.getImage(), pieza.getImage())) {

            return movimientosCaballo(xPieza, yPieza, xCasillaObjetivo, yCasillaObjetivo);
        } else if (compImagenes(Modelo.peonB.getImage(), pieza.getImage()) || compImagenes(Modelo.peonN.getImage(), pieza.getImage())) {

            return movimientosPeon(xPieza, yPieza, xCasillaObjetivo, yCasillaObjetivo, pieza, null);
        } else if (compImagenes(Modelo.torreBlanca.getImage(), pieza.getImage()) || compImagenes(Modelo.torreNegra.getImage(), pieza.getImage())) {

            return movimientoTorre(xPieza, yPieza, xCasillaObjetivo, yCasillaObjetivo);
        } else if (compImagenes(Modelo.reinaB.getImage(), pieza.getImage()) || compImagenes(Modelo.reinaN.getImage(), pieza.getImage())) {

            return movimientoReina(xPieza, yPieza, xCasillaObjetivo, yCasillaObjetivo);
        } else if (compImagenes(Modelo.bishopBlanco.getImage(), pieza.getImage()) || compImagenes(Modelo.bishopNegro.getImage(), pieza.getImage())) {

            return movimientoBishop(xPieza, yPieza, xCasillaObjetivo, yCasillaObjetivo);
        } else if (compImagenes(Modelo.reyB.getImage(), pieza.getImage()) || compImagenes(Modelo.reyN.getImage(), pieza.getImage())) {

            return movimientoRey(xPieza, yPieza, xCasillaObjetivo, yCasillaObjetivo);
        }

        return false;
    }

    public void promocionPeon(int xInicial, int yInicial, int xFinal, int yFinal) {
        Stage contenedor = new Stage();

        if (piezaBlanca(Modelo.imagePiezaI)) {
            if (esPeon()) {
                if (xFinal == 0) {
                    
                    Image TorreBlanca = new Image("/ec/edu/espol/chessg12/imagenes/torre blanca.png");
                    ImageView torreNegra1 = new ImageView(TorreBlanca);
                    torreNegra1.setFitWidth(80);
                    torreNegra1.setFitHeight(80);
                    Image ReinaBlanca = new Image("/ec/edu/espol/chessg12/imagenes/reina blanca.png");
                    ImageView torreNegra2 = new ImageView(ReinaBlanca);
                    torreNegra2.setFitWidth(80);
                    torreNegra2.setFitHeight(80);
                    Image Bishopblanco = new Image("/ec/edu/espol/chessg12/imagenes/bishop blanco.png");
                    ImageView torreNegra3 = new ImageView(Bishopblanco);
                    torreNegra3.setFitWidth(80);
                    torreNegra3.setFitHeight(80);
                    Image CaballoBlanco = new Image("/ec/edu/espol/chessg12/imagenes/caballo blanco.png");
                    ImageView torreNegra4 = new ImageView(CaballoBlanco);
                    torreNegra4.setFitWidth(80);
                    torreNegra4.setFitHeight(80);
                    Button botonBishop = new Button();
                    botonBishop.setGraphic(torreNegra3);
                    Button botonTorre = new Button();
                    botonTorre.setGraphic(torreNegra1);
                    Button botonCaballo = new Button();
                    botonCaballo.setGraphic(torreNegra4);
                    Button botonReina = new Button();
                    botonReina.setGraphic(torreNegra2);
                    Scene alerta = new Scene(new VBox(botonBishop, botonTorre, botonReina, botonCaballo), 100, 400);
                    contenedor.setScene(alerta);
                    contenedor.show();
                    botonBishop.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.bishopBlanco);

                        contenedor.close();

                    });

                    botonTorre.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.torreBlanca);

                        contenedor.close();

                    });

                    botonCaballo.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.caballoBlanco);

                        contenedor.close();

                    });

                    botonReina.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.reinaB);

                        contenedor.close();

                    });

                }
            }
        } else {

            if (esPeon()) {
                if (xFinal == 7) {
                    System.out.println("si llegaste iwi");
                    Image TorreBlanca = new Image("/ec/edu/espol/chessg12/imagenes/torre negra.png");
                    ImageView torreNegra1 = new ImageView(TorreBlanca);
                    torreNegra1.setFitWidth(80);
                    torreNegra1.setFitHeight(80);
                    Image ReinaBlanca = new Image("/ec/edu/espol/chessg12/imagenes/reina negra.png");
                    ImageView torreNegra2 = new ImageView(ReinaBlanca);
                    torreNegra2.setFitWidth(80);
                    torreNegra2.setFitHeight(80);
                    Image Bishopblanco = new Image("/ec/edu/espol/chessg12/imagenes/bishop negro.png");
                    ImageView torreNegra3 = new ImageView(Bishopblanco);
                    torreNegra3.setFitWidth(80);
                    torreNegra3.setFitHeight(80);
                    Image CaballoBlanco = new Image("/ec/edu/espol/chessg12/imagenes/caballo negro.png");
                    ImageView torreNegra4 = new ImageView(CaballoBlanco);
                    torreNegra4.setFitWidth(80);
                    torreNegra4.setFitHeight(80);
                    Button botonBishop = new Button();
                    botonBishop.setGraphic(torreNegra3);
                    Button botonTorre = new Button();
                    botonTorre.setGraphic(torreNegra1);
                    Button botonCaballo = new Button();
                    botonCaballo.setGraphic(torreNegra4);
                    Button botonReina = new Button();
                    botonReina.setGraphic(torreNegra2);
                    Scene alerta = new Scene(new VBox(botonBishop, botonTorre, botonReina, botonCaballo), 100, 400);
                    contenedor.setScene(alerta);
                    contenedor.show();

                    botonBishop.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.bishopNegro);

                        contenedor.close();

                    });

                    botonTorre.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.torreNegra);

                        contenedor.close();

                    });

                    botonCaballo.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.caballoNegro);

                        contenedor.close();

                    });

                    botonReina.setOnMouseClicked(e -> {

                        b[yFinal][xFinal].setGraphic(Modelo.reinaN);

                        contenedor.close();

                    });

                }
            }

        }
    }
}
