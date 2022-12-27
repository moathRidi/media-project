package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Driver extends Application {
	private static   String datar="";

	@Override
	public void start(Stage primaryStage) throws IOException {
		MediaRentalMannegar ridi = new MediaRentalMannegar();
		File fcos = new File("costomer.txt");
		if (!fcos.exists()) {
			fcos.createNewFile();
		}
		File fmed = new File("media.txt");
		if (!fmed.exists()) {
			fmed.createNewFile();
		}
		File fcart = new File("cart.txt");
		if (!fcart.exists()) {
			fcart.createNewFile();
		}
		File frent = new File("rent.txt");
		if (!frent.exists()) {
			frent.createNewFile();
		}
		Scanner inf = new Scanner(fcos);
		Scanner inf2 = new Scanner(fmed);
		Scanner inf3 = new Scanner(fcart);
		Scanner inf4 = new Scanner(frent);
      
   
		while (inf.hasNext()) {

			String a = inf.nextLine();
			a = a.replaceAll("[\\[\\](){} ]", "");

			String[] x = a.split(",");
			String l = "";
			for (int s = 0; s < x.length; s++) {
				for (int q = x[s].indexOf('='); q < x[s].length(); q++) {// start point at the = sign
					l += x[s].charAt(q);

				}

			}
			l = l.replaceFirst("=", "");
		
			String []vvz = l.split("=");
			String m1 = vvz[0];
			String m2 = vvz[1];
			String m3 = vvz[2];
			String m4 = vvz[3];
		   	String m55= vvz[4];
		   	
		
			 if(m55.equalsIgnoreCase("limited")) {
				String  m66 = vvz[5];
				
				ridi.addCustomerlim(m1, m2, m3, m4, m55,Integer.parseInt(m66));
				
				
			 }
			 
			 else
				 ridi.addCustomerunlim(m1, m2, m3, m4, m55);
		}
		
		inf.close();

		while (inf2.hasNext()) {
			String ch = "";
			ch = inf2.next();

			if (ch.charAt(0) == 'G' | ch.indent(1).charAt(2) == 'G') {

				String a = inf2.nextLine();
				a = a.replaceAll("[\\[\\](){}]", "");
				a = a.replaceFirst("Code ", "");
				String[] x = a.split(" ");

				String l = "";
				for (int s = 0; s < x.length; s++) {
					for (int q = x[s].indexOf('=') + 1; q < x[s].length(); q++) {// start point at the = sign
						l += x[s].charAt(q);
					}
				}
				l = l.replaceAll(",", " ");

				String[] p = l.split(" ");
				String m1 = p[0];
				String m2 = p[1];
				String m3 = p[2];
				String m4 = p[3];
				int q = Integer.parseInt(m3);
				double n = Double.parseDouble(m4);
				ridi.addGame(m2, q, n, m1);

			} else if (ch.charAt(0) == 'M' | ch.indent(1).charAt(2) == 'M') {

				String a = inf2.nextLine();
				a = a.replaceAll("[\\[\\](){}]", "");
				a = a.replaceFirst("Code", "");
				String[] x = a.split(" ");

				String l = "";
				for (int s = 0; s < x.length; s++) {
					for (int q = x[s].indexOf('=') + 1; q < x[s].length(); q++) {// start point at the = sign
						l += x[s].charAt(q);
					}
				}
				l = l.replaceAll(",", " ");

				String[] p = l.split(" ");
				String m1 = p[0];
				String m2 = p[1];
				String m3 = p[2];
				String m4 = p[3];
				int q = Integer.parseInt(m3);

				ridi.addMovie(m2, q, m4, m1);
			}

			else if (ch.charAt(0) == 'A' | ch.indent(1).charAt(2) == 'A') {
				String a = inf2.nextLine();

				a = a.replaceAll("[\\[\\](){}]", "");
				a = a.replaceFirst("Code", "");

				String[] x = a.split(" ");
				String l = "";
				for (int s = 0; s < x.length; s++) {
					for (int q = x[s].indexOf('=') + 1; q < x[s].length(); q++) {// start point at the = sign
						l += x[s].charAt(q);

					}
				}

				l = l.replaceAll(",", " ");

				String[] p = l.split(" ");
				String m1 = p[0];
				String m2 = p[1];
				String m3 = p[2];
				String m4 = p[3];
				String m5 = p[4];

				int q = Integer.parseInt(m3);

				ridi.addAlbum(m2, q, m4, m5, m1);
			}

		}

		inf2.close();

		while (inf3.hasNext()) {

			String a = inf3.nextLine();
			a = a.replaceAll("[\\[\\](){}]", "");

			String[] x = a.split(",");

			String m1 = x[0];
			String m2 = x[1];
			try {

				ridi.addToCart(m1, m2);
				
			} catch (Exception e) {
				System.out.println(e);
			}
 
		}
	
		inf3.close();
		
		/*  while (inf4.hasNext()) {
		  
		  String a = inf4.nextLine(); a = a.replaceAll("[\\[\\](){}]", "");
		  
		  String[] x = a.split(",");
		 
		  String m1 = x[0]; String m2 = x[1]; try {
		  
		  ridi.addToCart(m1, m2); } catch (Exception e) { System.out.println(e); }
		  
		  }
		  
		  inf4.close();
		 */
		try {
			primaryStage.setTitle("Rental Manegar System");
			BorderPane panem = new BorderPane();

			StackPane stak = new StackPane();
			stak.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

			panem.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scene2 = new Scene(panem, 1700, 800);
			scene2.setFill(Color.SKYBLUE);
			
			BorderPane pane1z = new BorderPane();
			pane1z.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
			
			GridPane pane = new GridPane();
			pane.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			
			BorderPane pane1 = new BorderPane();
			pane1.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scene = new Scene(pane1, 1700, 800);

			Scene coscen = new Scene(pane1z, 1700, 800);

			GridPane panex = new GridPane();
			panex.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scenex = new Scene(panex, 1700, 800);

			GridPane pan = new GridPane();
			pan.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene sce = new Scene(pan, 1700, 800);

			BorderPane serid = new BorderPane();
			serid.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene ser = new Scene(serid, 1550, 830);

			BorderPane so = new BorderPane();

			so.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scene00 = new Scene(so, 1550, 830);

			BorderPane sos = new BorderPane();

			sos.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scene3 = new Scene(sos, 1700, 800);

			BorderPane gg = new BorderPane();
			gg.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scene4 = new Scene(gg, 1700, 800);

			BorderPane delm = new BorderPane();
			delm.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene dels = new Scene(delm, 1550, 830);

			BorderPane mup = new BorderPane();
			mup.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene msc = new Scene(mup, 1700, 800);

			BorderPane print = new BorderPane();
			print.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene prs = new Scene(print, 1550, 830);

			BorderPane rent = new BorderPane();

			rent.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scenerent = new Scene(rent, 1700, 800);

			GridPane pane2 = new GridPane();
			pane.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

			BorderPane pn = new BorderPane();
			Scene scene5 = new Scene(pn, 1700, 800);

			BorderPane pcart = new BorderPane();
			pcart.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scart = new Scene(pcart, 1700, 800);

			BorderPane reet = new BorderPane();
			reet.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene scene6 = new Scene(reet, 1700, 800);

			BorderPane pren = new BorderPane();
			pren.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene sren = new Scene(pren, 1700, 800);
			
			BorderPane serc =new BorderPane();
			serc.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			Scene sercs = new Scene(serc, 1700, 800);

			VBox vbx = new VBox();
			vbx.setAlignment(Pos.CENTER);
			vbx.setSpacing(50);
			vbx.setPadding(new Insets(0, 0, 0, 100));
			// images//

			ImageView cosimg = new ImageView("user-group-icon.png");
			cosimg.setFitWidth(80);
			cosimg.setPreserveRatio(true);
			ImageView medimg = new ImageView("games-96-icon.png");
			medimg.setFitWidth(97);
			medimg.setPreserveRatio(true);
			ImageView rentimg = new ImageView("shopping-96-icon.png");
			rentimg.setFitWidth(107);
			rentimg.setPreserveRatio(true);

			ImageView bgimg = new ImageView("Folder-TV-Disney-icon.png");
			bgimg.setFitWidth(700);
			bgimg.setPreserveRatio(true);
			stak.getChildren().add(bgimg);
			pane1.setCenter(stak);
			// buttons//
			Button cbn = new Button("Costomer", cosimg);
			cbn.setFont(Font.font(19));
			cbn.setStyle("-fx-border-color: black");
			cbn.setStyle("-fx-base: lightgreen");
			
			Button mbn = new Button("Media", medimg);
			mbn.setFont(Font.font(21));
			mbn.setStyle("-fx-border-color: black");
			mbn.setStyle("-fx-base: lightgreen");
			Button rbn = new Button("Rent", rentimg);
			rbn.setFont(Font.font(24));
			rbn.setStyle("-fx-border-color: black");
			rbn.setStyle("-fx-base: lightgreen");
			vbx.getChildren().addAll(cbn, mbn, rbn);
			pane1.setLeft(vbx);

			Text wtx = new Text(720, 740, "RIDI'S Rental Media System");
			wtx.setTextAlignment(TextAlignment.CENTER);
			DropShadow shadow = new DropShadow();
			shadow.setOffsetX(1);
			shadow.setOffsetY(-7);
			wtx.setEffect(shadow);
			Text wtx2 = new Text(1140, 270, "BY:Moath Ridi");
			wtx2.setFont(Font.font(null, FontWeight.BOLD, wtx2.getFont().getSize()));
			wtx2.setTextAlignment(TextAlignment.CENTER);
			wtx.setFont(Font.font(50));
			wtx2.setEffect(shadow);
			pane1.getChildren().addAll(wtx, wtx2);

			cbn.setOnAction(e -> {
				pane.setPadding(new Insets(40, 40, 20, 40));
				Label sss = new Label(" 30 % SALE !");
				sss.setAlignment(Pos.CENTER_LEFT);
				sss.setTextFill(Color.RED);
				sss.setUnderline(true);
				sss.setFont(Font.font(30));
				panem.setTop(sss);
				VBox ww = new VBox();
				ww.setPadding(new Insets(20, 0, 0, 0));
				ww.setSpacing(70);
				ImageView addq = new ImageView("New-Years-Eve-icon.png");

				addq.setFitWidth(300);

				addq.setLayoutX(0);
				addq.setLayoutY(100);
				addq.setPreserveRatio(true);

				panem.setLeft(addq);

				ImageView addm = new ImageView("BD-Files-icon.png");

				ww.getChildren().addAll(addq, addm);

				panem.setLeft(ww);

				GridPane gp = new GridPane();
				gp.setVgap(15);
				gp.setPadding(new Insets(0, 0, 0, 0));
				gp.setAlignment(Pos.CENTER);
				Text tx0 = new Text("> Please Select One <");

				tx0.setFill(Color.DARKRED);
				tx0.setUnderline(true);
				tx0.setFont(Font.font(60));

				shadow.setOffsetX(0);
				shadow.setOffsetY(-3);
				shadow.setColor(Color.CHOCOLATE);
				Text tx1 = new Text("1- Add new Costomer");
				tx1.setFont(Font.font(50));
				tx1.setEffect(shadow);
				Text tx2 = new Text("2- Delete Customer");
				tx2.setFont(Font.font(50));
				tx2.setEffect(shadow);

				Text tx3 = new Text("3- Update Information about Customer");
				tx3.setFont(Font.font(50));
				tx3.setEffect(shadow);
				Text tx4 = new Text("4- Search a Customer by ID");
				tx4.setFont(Font.font(50));
				tx4.setEffect(shadow);
				Text tx5 = new Text("5- Print All Customer Information");
				tx5.setFont(Font.font(50));
				tx5.setEffect(shadow);
				Text tx6 = new Text("6- Return to main page");

				tx6.setFont(Font.font(50));
				tx6.setEffect(shadow);

				gp.add(tx0, 0, 0);

				gp.add(tx1, 0, 1);
				gp.add(tx2, 0, 2);
				gp.add(tx3, 0, 3);
				gp.add(tx4, 0, 4);
				gp.add(tx5, 0, 5);
				gp.add(tx6, 0, 6);
				panem.setCenter(gp);
				tx1.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx1.setFill(Color.BLUE);
						tx1.setUnderline(true);
						tx2.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);
						tx2.setUnderline(false);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx6.setUnderline(false);
					}
				});
				tx2.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx2.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);

						tx1.setUnderline(false);
						tx2.setUnderline(true);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx6.setUnderline(false);

					}
				});

				tx3.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx3.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);

						tx2.setUnderline(false);
						tx3.setUnderline(true);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx1.setUnderline(false);
						tx6.setUnderline(false);

					}
				});
				tx4.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx4.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);

						tx4.setUnderline(true);
						tx3.setUnderline(false);
						tx5.setUnderline(false);
						tx2.setUnderline(false);
						tx1.setUnderline(false);
						tx6.setUnderline(false);

					}
				});
				tx5.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx5.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);
						tx5.setUnderline(true);
						tx4.setUnderline(false);
						tx3.setUnderline(false);
						tx2.setUnderline(false);
						tx1.setUnderline(false);
						tx6.setUnderline(false);

					}
				});
				tx6.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx6.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);

						tx6.setUnderline(true);
						tx4.setUnderline(false);
						tx3.setUnderline(false);
						tx2.setUnderline(false);
						tx1.setUnderline(false);
						tx5.setUnderline(false);
					}
				});

				tx1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(coscen);
						primaryStage.show();
					}
				});

				tx2.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scenex);
						primaryStage.show();
					}
				});

				tx3.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(sce);
						primaryStage.show();
					}
				});

				tx4.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(ser);
						primaryStage.show();
					}
				});

				tx5.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scene00);
						primaryStage.show();

					}
				});
				tx6.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scene);
						primaryStage.show();

					}
				});

				primaryStage.setScene(scene2);
				primaryStage.show();

			});

			//////////////////// ADDING Customer////////////////////////////

			pane.setAlignment(Pos.CENTER);
			pane1z.setPadding(new Insets(25, 40, 40, 20));
			pane.setHgap(15);
			pane.setVgap(20);
			HBox ddx = new HBox();
		
			Label addingCus = new Label("please Enter Customer Information:");
			ddx.setAlignment(Pos.CENTER);
			
			addingCus.setFont(Font.font(40));
			addingCus.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));
          
            ddx.getChildren().add(addingCus);
            pane1z.setTop(ddx);
			Label id = new Label("Customer ID:");
			id.setFont(Font.font(30));
			Label name = new Label("Customer Name:");
			name.setFont(Font.font(30));

			Label addres = new Label("Customer Adress:");
			addres.setFont(Font.font(30));

			Label mobile = new Label("Customer Mobile:");
			mobile.setFont(Font.font(30));

			Label plan = new Label("Customer plan:");
			plan.setFont(Font.font(30));

			TextField i = new TextField();
			i.setPrefColumnCount(30);
			TextField n = new TextField();
			TextField a = new TextField();
			TextField m = new TextField();
			n.setDisable(true);
			a.setDisable(true);
			m.setDisable(true);

			ImageView addimg = new ImageView("add-user-icon.png");
			addimg.setFitWidth(50);
			addimg.setPreserveRatio(true);
			ImageView backimg = new ImageView("Go-222back-icon.png");
			backimg.setFitWidth(50);
			backimg.setPreserveRatio(true);
			Button adds = new Button(null, addimg);

			Button back = new Button(null, backimg);
			HBox hk = new HBox();
		
			hk.setAlignment(Pos.CENTER);
			hk.getChildren().addAll(back,adds);
			hk.setSpacing(180);
	        hk.setMaxWidth(1500);
		    pane1z.setBottom(hk);

			HBox hn = new HBox();
			hn.setSpacing(10);

			RadioButton limb = new RadioButton("LIMITED");
			
			limb.setFont(Font.font(25));
			RadioButton unlimbt = new RadioButton("UNLIMITED");
			unlimbt.setFont(Font.font(25));

			hn.getChildren().addAll(limb, unlimbt);
			hn.setDisable(true);
			pane.add(hn, 1, 4);

			i.setOnKeyReleased(w -> {
				n.setDisable(false);
				a.setDisable(true);
				m.setDisable(true);
			});

			n.setOnKeyReleased(w -> {

				a.setDisable(false);
				m.setDisable(true);
			});

			a.setOnKeyReleased(w -> {

				m.setDisable(false);
			});

			m.setOnKeyReleased(w -> {
				hn.setDisable(false);
			});

			if (i.getText() == "") {
				n.setDisable(true);
				m.setDisable(true);
				a.setDisable(true);
			}
			if (a.getText() == "") {
				m.setDisable(true);

			}
			if (n.getText() == "") {
				m.setDisable(true);

				a.setDisable(true);
			}

			pane.add(id, 0, 0);
			pane.add(i, 1, 0);
			pane.add(name, 0, 1);
			pane.add(n, 1, 1);
			pane.add(addres, 0, 2);
			pane.add(a, 1, 2);
			pane.add(mobile, 0, 3);
			pane.add(m, 1, 3);
			pane.add(plan, 0, 4);

			TextField limn = new TextField();
			ToggleGroup tg = new ToggleGroup();
			limb.setToggleGroup(tg);
			unlimbt.setToggleGroup(tg);
			limb.setOnAction(e -> {
				Label limnum = new Label("Limit Size number:");
				limnum.setFont(Font.font(30));
				limn.setDisable(false);
				pane.add(limnum, 0, 5);
				pane.add(limn, 1, 5);
				HBox dd = new HBox();
				dd.setMaxWidth(1500);
				dd.setSpacing(150);
				dd.getChildren().addAll(back,adds);
				dd.setAlignment(Pos.CENTER);
				pane1z.setBottom(dd);
			});
			unlimbt.setOnAction(w -> {
				limn.setDisable(true);
			});
			
			Text mass = new Text("\t\t\t\t\t\t\t\tCostomer Added Succesfully");
			Text mass2 = new Text("\t\t\t\t\t\t\t\tCostomer already exist");
			
			Label masss = new Label("\t\t\t\t\t\t\t\tCostomer Added Succesfully");
      		 Label mass1 = new Label("\t\t\t\t\t\t\t\tCostomer already exist");
			adds.setOnAction(e -> {
				Text error = new Text("This fild is Empty");
				if (i.getText() == "") {

					error.setFill(Color.RED);
					pane.add(error, 2, 1);

				} else if (i.getText() != "") {

					error.setFill(Color.SKYBLUE);
					error.setStroke(Color.SKYBLUE);

					pane.add(error, 2, 1);
				}
 
	

				
				if (limb.isSelected()) {

           		 
                         if(limn.getText().trim().isEmpty()) {
                        	 
                        	if( ridi.addCustomerlim(i.getText(), n.getText(), a.getText(), m.getText(), "LIMITED",2)) {

                        		mass1.setTextFill(Color.SKYBLUE);
    						
    							mass1.setFont(Font.font(0.2));
    							    							
    							masss.setTextFill(Color.GREEN);
    							masss.setFont(Font.font(15));
    							pane.add(masss, 0, 9);
    							n.clear();
    							a.clear();
    							limn.clear();
    							i.clear();
    							m.clear();

    						} else {
    							
    							masss.setTextFill(Color.SKYBLUE);
    							masss.setFont(Font.font(0.2));
    							
    							mass1.setTextFill(Color.RED);
    							mass1.setFont(Font.font(15));
    							pane.add(mass1, 0, 9);

    							n.clear();
    							a.clear();
    							limn.clear();
    							i.clear();
    							m.clear();

    						}
                        	}
                        	 
                         
                         else
				{
				            int flag=1;
				            boolean ff=false;
				            boolean ff0=true;
                        	 try {
                        		 Integer.parseInt(limn.getText());
                        	 }
                        	 catch (Exception es) {
                        		
                        		 limn.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                        		 flag=0;
                        		
							}
                        	
                        		 if(flag==1) {
                        			 ff=ridi.addCustomerlim(i.getText(), n.getText(), a.getText(), m.getText(), "LIMITED",Integer.parseInt(limn.getText()));
                        			ff0=ff;
                        			 limn.setStyle("-fx-border-color: white ; -fx-border-width: 0px ;");
                        		 }
                        		
                        	 
						if (ff==true) {
						
							mass1.setTextFill(Color.SKYBLUE);
							mass1.setFont(Font.font(0.2));
							
							masss.setTextFill(Color.GREEN);
							masss.setFont(Font.font(15));
							pane.add(masss, 0, 9);
							n.clear();
							a.clear();
							limn.clear();
							i.clear();
							m.clear();
							

						} else if(ff0==false) {
							masss.setTextFill(Color.SKYBLUE);
							masss.setFont(Font.font(0.2));
							mass1.setTextFill(Color.RED);
							mass1.setFont(Font.font(15));
							pane.add(mass1, 0, 9);

							n.clear();
							a.clear();
							limn.clear();
							i.clear();
							m.clear();

						}
						
						
					}
					
					
				} else if (unlimbt.isSelected()) {
					
					
					if (ridi.addCustomerunlim(i.getText(), n.getText(), a.getText(), m.getText(), "UNLIMITED")) {

						mass2.setFill(Color.SKYBLUE);
						mass2.setFont(Font.font(0.1));
						
						mass.setFill(Color.GREEN);
						mass.setFont(Font.font(15));
						pane.add(mass, 0, 8);
						n.clear();
						a.clear();
						limn.clear();
						i.clear();
						m.clear();

					} else {
						mass.setFill(Color.SKYBLUE);
						mass.setFont(Font.font(0.1));
						
						mass2.setFill(Color.RED);
						mass2.setFont(Font.font(15));
						pane.add(mass2, 0, 8);

						n.clear();
						a.clear();
						limn.clear();
						i.clear();
						m.clear();

					}

				}
			});

			back.setOnAction(e -> primaryStage.setScene(scene2));
			
			pane1z.setCenter(pane);
			////////////////////// DElete customer/////////////////////////////////////

			panex.setAlignment(Pos.CENTER);
			panex.setPadding(new Insets(15, 10, 15, 20));
			panex.setHgap(15);
			panex.setVgap(20);

			Label delCus = new Label("please Enter Customer Information:");
			delCus.setFont(Font.font(40));
			delCus.setFont(Font.font(null, FontPosture.ITALIC, delCus.getFont().getSize()));

			Label ids = new Label("Customer ID:");
			ids.setFont(Font.font(30));
			Label names = new Label("Customer Name:");
			names.setFont(Font.font(30));
			Label address = new Label("Customer Adress:");
			address.setFont(Font.font(30));
			Label mobiles = new Label("Customer Mobile:");
			mobiles.setFont(Font.font(30));
			Label plans = new Label("Customer plan:");
			plans.setFont(Font.font(30));
			TextField is = new TextField();
			is.setPrefColumnCount(30);
			TextField ns = new TextField();
			TextField as = new TextField();
			TextField ms = new TextField();
			TextField ps = new TextField();
			ns.setDisable(true);
			as.setDisable(true);
			ms.setDisable(true);
			ps.setDisable(true);

			panex.add(ids, 0, 0);
			panex.add(is, 1, 0);
			panex.add(names, 0, 1);
			panex.add(ns, 1, 1);
			panex.add(address, 0, 2);
			panex.add(as, 1, 2);
			panex.add(mobiles, 0, 3);
			panex.add(ms, 1, 3);
			panex.add(plans, 0, 4);
			panex.add(ps, 1, 4);
			is.setOnKeyReleased(w -> {
				ns.setDisable(false);
				as.setDisable(true);
				ms.setDisable(true);
				ps.setDisable(true);
			});

			ns.setOnKeyReleased(w -> {

				as.setDisable(false);
				ms.setDisable(true);
				ps.setDisable(true);
			});

			as.setOnKeyReleased(w -> {

				ms.setDisable(false);
				ps.setDisable(true);
			});

			ms.setOnKeyReleased(w -> {
				ps.setDisable(false);
			});

			ImageView findimg = new ImageView("search2222-icon.png");
			findimg.setFitWidth(40);
			findimg.setPreserveRatio(true);
			ImageView deleteimg = new ImageView("User-Delete-icon.png");
			deleteimg.setFitWidth(40);
			deleteimg.setPreserveRatio(true);
			ImageView bakimg = new ImageView("Go-222back-icon.png");
			bakimg.setFitWidth(40);
			bakimg.setPreserveRatio(true);
			Button find = new Button(null, findimg);

			Button del = new Button(null, deleteimg);

			Button backs = new Button(null, bakimg);

			panex.add(backs, 0, 5);
			panex.add(find, 1, 5);
			panex.add(del, 2, 5);

			find.setOnAction(e -> {
				if (ridi.findCustomer(is.getText())) {
					ImageView tr = new ImageView("Actions-dialog-ok-apply-icon.png");
					Button trb = new Button(null, tr);
					tr.setFitWidth(15);
					tr.setPreserveRatio(true);
					panex.add(trb, 2, 0);
				} else {
					ImageView tr = new ImageView("Actions-edit-delete-icon.png");
					tr.setFitWidth(15);
					tr.setPreserveRatio(true);
					Button trb = new Button(null, tr);

					panex.add(trb, 2, 0);
				}

			});

			del.setOnAction(e -> {
				if (ridi.removeCustomer(is.getText())) {
					ImageView tr = new ImageView("Actions-edit-delete-icon.png");
					tr.setFitWidth(15);
					tr.setPreserveRatio(true);
					Button trb = new Button(null, tr);

					panex.add(trb, 2, 0);
					ns.clear();
					as.clear();
					ps.clear();
					is.clear();
					ms.clear();
					Label done = new Label("Customer deleted succesfuly:");
					done.setFont(Font.font(20));
					done.setTextFill(Color.GREEN);
					panex.add(done, 1, 6);
				} else {
					Label not = new Label("Customer not founded");
					not.setFont(Font.font(20));
					not.setTextFill(Color.RED);
					panex.add(not, 1, 6);
				}
			});

			backs.setOnAction(e -> primaryStage.setScene(scene2));

			////////////////////// Update info/////////////////////////////////////
			pan.setAlignment(Pos.CENTER);
			pan.setPadding(new Insets(10, 10, 15, 20));
			pan.setHgap(15);
			pan.setVgap(20);

			Label upCus = new Label("please Enter Customer Information:");
			upCus.setFont(Font.font(40));
			upCus.setFont(Font.font(null, FontPosture.ITALIC, upCus.getFont().getSize()));
			Label cids = new Label("Customer ID:");
			cids.setFont(Font.font(30));
			Label cnames = new Label("Customer Name:");
			cnames.setFont(Font.font(30));
			Label caddress = new Label("Customer Adress:");
			caddress.setFont(Font.font(30));
			Label cmobiles = new Label("Customer Mobile:");
			cmobiles.setFont(Font.font(30));
			Label cplans = new Label("Customer plan:");
			cplans.setFont(Font.font(30));
			TextField cns = new TextField();
			TextField cas = new TextField();
			TextField cms = new TextField();
			TextField cps = new TextField();
			TextField cis = new TextField();
			cis.setPrefColumnCount(30);

			cns.setDisable(true);
			cas.setDisable(true);
			cms.setDisable(true);
			cps.setDisable(true);

			pan.add(cids, 0, 0);
			pan.add(cis, 1, 0);
			pan.add(cnames, 0, 1);
			pan.add(cns, 1, 1);
			pan.add(caddress, 0, 2);
			pan.add(cas, 1, 2);
			pan.add(cmobiles, 0, 3);
			pan.add(cms, 1, 3);
			pan.add(cplans, 0, 4);
			pan.add(cps, 1, 4);

			ImageView fimg = new ImageView("search2222-icon.png");
			fimg.setFitWidth(50);
			fimg.setPreserveRatio(true);
			ImageView upimg = new ImageView("Male-user-edit-icon.png");
			upimg.setFitWidth(50);
			upimg.setPreserveRatio(true);
			ImageView bimg = new ImageView("Go-222back-icon.png");
			bimg.setFitWidth(50);
			bimg.setPreserveRatio(true);

			Button fb = new Button(null, fimg);

			Button upb = new Button(null, upimg);
			cis.setOnKeyReleased(w -> {
				if (ridi.findCustomer(cis.getText())) {
					cns.setDisable(false);
					cas.setDisable(false);
					cms.setDisable(false);
					cps.setDisable(false);
				}
			});

			upb.setOnAction(e -> {
				
			if(!cis.getText().trim().isEmpty()&& !cns.getText().trim().isEmpty()&&!cas.getText().trim().isEmpty()&& !cms.getText().trim().isEmpty()&&!cps.getText().trim().isEmpty()) {
				ridi.updateInfo(cis.getText(), cns.getText(), cas.getText(), cms.getText(), cps.getText());

				cis.clear();
				cns.clear();
				cas.clear();
				cms.clear();
				cps.clear();
			}
				
				
				
			

			});
			fb.setOnAction(e -> {
				if (ridi.findCustomer(cis.getText())) {
					String k = ridi.secCustomer(cis.getText());
					System.out.println(k);

					k = k.replaceAll("[\\[\\](){} ]", "");

					String[] x = k.split(",");
					String l = "";
					for (int s = 0; s < x.length; s++) {
						for (int q = x[s].indexOf('='); q < x[s].length(); q++) {// start point at the = sign
							l += x[s].charAt(q);

						}

					}
					l = l.replaceFirst("=", "");

					String[] p = l.split("=");
					String m1 = p[0];
					String m2 = p[1];
					String m3 = p[2];
					String m4 = p[3];
					String m5 = p[4];

					cis.setText(m1);
					cns.setText(m2);
					cas.setText(m3);
					cms.setText(m4);
					cps.setText(m5);

					cis.setOnKeyReleased(w -> {
						if (ridi.findCustomer(cis.getText())) {
							cns.setDisable(false);
							cas.setDisable(false);
							cms.setDisable(false);
							cps.setDisable(false);
						}
					});

					ImageView tr = new ImageView("Actions-dialog-ok-apply-icon.png");
					Button trb = new Button(null, tr);
					tr.setFitWidth(15);
					tr.setPreserveRatio(true);
					pan.add(trb, 2, 0);
				} else {
					ImageView tr = new ImageView("Actions-edit-delete-icon.png");
					tr.setFitWidth(15);
					tr.setPreserveRatio(true);
					Button trb = new Button(null, tr);

					pan.add(trb, 2, 0);
				}

			});

			Button bks = new Button(null, bimg);
			pan.add(bks, 0, 5);
			pan.add(upb, 1, 5);
			pan.add(fb, 2, 5);

			bks.setOnAction(e -> primaryStage.setScene(scene2));

			///////////////// Search BY ID/////////////////////////////
			HBox shb = new HBox();
			shb.setSpacing(60);
			Label si = new Label("Please Enter Customer ID");
			si.setFont(Font.font(30));
			si.setFont(Font.font(null, FontWeight.BOLD, addingCus.getFont().getSize()));

			TextField itf = new TextField();

			itf.setPrefColumnCount(30);
			itf.setFont(Font.font(15));
			// itf.setFont(Font.font(null,FontWeight.BOLD,addingCus.getFont().getSize()));
			shb.getChildren().addAll(si, itf);

			shb.setAlignment(Pos.CENTER);

			serid.setPadding(new Insets(60, 30, 0, 0));

			ImageView findim = new ImageView("search2222-icon.png");
			findim.setFitWidth(40);
			findim.setPreserveRatio(true);

			ImageView bakim = new ImageView("Go-222back-icon.png");
			bakim.setFitWidth(40);
			bakim.setPreserveRatio(true);
			Button finds = new Button(null, findim);

			Button backi = new Button(null, bakim);
			HBox hbtn = new HBox();
			hbtn.setSpacing(150);
			hbtn.getChildren().addAll(backi, finds);
			hbtn.setAlignment(Pos.CENTER);

			backi.setOnAction(e -> primaryStage.setScene(scene2));

			VBox idvb = new VBox();
			idvb.setSpacing(15);
			idvb.getChildren().addAll(shb, hbtn);
			serid.setTop(idvb);

			TextArea tar2 = new TextArea(null);
			tar2.setPadding(new Insets(50, 50, 50, 50));
			tar2.setFont(Font.font(20));
			tar2.setDisable(true);

			finds.setOnAction(e -> {

				tar2.setText(ridi.secCustomer(itf.getText()));

				itf.clear();

			});
			serid.setCenter(tar2);

			so.setPadding(new Insets(70, 70, 70, 70));
			HBox phb2 = new HBox();
			phb2.setPadding(new Insets(40, 0, 40, 40));

			Text ttt2 = new Text(" All information of Customer");
			ttt2.setFont(Font.font(70));
			ttt2.setUnderline(true);
			ttt2.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));

			phb2.getChildren().add(ttt2);
			phb2.setAlignment(Pos.CENTER);

			TextArea tar31 = new TextArea(null);
		
			tar31.setFont(Font.font(15));
			tar31.setDisable(false);

			ImageView bb3 = new ImageView("Go-222back-icon.png");
			Button pb3 = new Button(null, bb3);
			bb3.setFitWidth(40);
			bb3.setPreserveRatio(true);
			pb3.setAlignment(Pos.CENTER);

			ImageView pr3 = new ImageView("Programming-Show-Property-icon.png");
			Button prb3 = new Button(null, pr3);
			pr3.setFitWidth(40);
			pr3.setPreserveRatio(true);
			prb3.setAlignment(Pos.CENTER);
			HBox hha3 = new HBox();
			hha3.setSpacing(1000);
			hha3.getChildren().addAll(pb3, prb3);
			so.setBottom(hha3);
			prb3.setOnAction(s -> {
				try {
					tar31.setText(ridi.getAllCustomersInfo());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			pb3.setOnAction(s -> {
tar31.clear();
				primaryStage.setScene(scene2);
			});
			so.setCenter(tar31);

			so.setTop(phb2);

			mbn.setOnAction(e -> {
				GridPane gpx = new GridPane();

				sos.setPadding(new Insets(0, 0, 10, 10));
				Label sss = new Label(" COMING SOON !");
				sss.setAlignment(Pos.CENTER_LEFT);
				sss.setTextFill(Color.GREEN);
				sss.setUnderline(true);
				sss.setFont(Font.font(30));
				// sos.setTop(sss);
				VBox ww = new VBox();
				ww.setPadding(new Insets(10, 0, 0, 10));
				ww.setSpacing(20);
				ImageView addq = new ImageView("game-battlefield-icon.png");

				addq.setFitWidth(400);

				addq.setPreserveRatio(true);

				sos.setLeft(addq);

				ImageView addm = new ImageView("The-Last-Song-icon.png");

				addm.setPreserveRatio(true);
				addm.setFitWidth(300);
				ww.getChildren().addAll(sss, addq, addm);

				sos.setLeft(ww);

				gpx.setVgap(15);
				// gp.setPadding(new Insets(20,30,20,30));
				gpx.setAlignment(Pos.CENTER);
				Text tx0 = new Text(" > Please Select One < ");
				tx0.setUnderline(true);
				tx0.setFont(Font.font(null, FontPosture.ITALIC, tx0.getFont().getSize()));
				tx0.setFont(Font.font(70));

				shadow.setOffsetX(0);
				shadow.setOffsetX(-3);
				shadow.setColor(Color.DARKRED);
				Text tx1 = new Text("1- Add new Media");
				tx1.setFont(Font.font(50));
				tx1.setEffect(shadow);
				Text tx2 = new Text("2- Find or Delete a Media By ID");
				tx2.setFont(Font.font(50));
				tx2.setEffect(shadow);
				Text tx6 = new Text("3- scerch Media ");
				tx6.setFont(Font.font(50));
				tx6.setEffect(shadow);
				Text tx3 = new Text("4- Update Information about");
				tx3.setFont(Font.font(50));
				tx3.setEffect(shadow);
				Text tx4 = new Text("5- Print All Media inform");
				tx4.setFont(Font.font(50));
				tx4.setEffect(shadow);
				Text tx5 = new Text("6- Return to main page");
				tx5.setFont(Font.font(50));
				tx5.setEffect(shadow);
				gpx.add(tx0, 0, 0);

				gpx.add(tx1, 0, 1);
				gpx.add(tx2, 0, 2);
				gpx.add(tx6, 0, 3);
				gpx.add(tx3, 0, 4);
				gpx.add(tx4, 0, 5);
				gpx.add(tx5, 0, 6);
				sos.setCenter(gpx);
				tx1.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {

					public void handle(MouseEvent me) {

						tx1.setFill(Color.BLUE);
						tx2.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);
						tx1.setUnderline(true);
						tx2.setUnderline(false);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx6.setUnderline(false);

					}
				});
				tx2.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx2.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);
						tx1.setUnderline(false);
						tx2.setUnderline(true);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx6.setUnderline(false);

					}
				});

				tx3.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx3.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);
						tx1.setUnderline(false);
						tx2.setUnderline(false);
						tx3.setUnderline(true);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx6.setUnderline(false);

					}
				});
				tx4.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx4.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);
						tx1.setUnderline(false);
						tx2.setUnderline(false);
						tx3.setUnderline(false);
						tx4.setUnderline(true);
						tx5.setUnderline(false);
						tx6.setUnderline(false);

					}
				});
				tx5.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx5.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx6.setFill(Color.BLACK);
						tx1.setUnderline(false);
						tx2.setUnderline(false);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(true);
						tx6.setUnderline(false);

					}
				});
				tx6.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {

					public void handle(MouseEvent me) {

						tx1.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx6.setFill(Color.BLUE);
						tx6.setUnderline(true);
						tx2.setUnderline(false);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx1.setUnderline(false);

					}
				});

				tx1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scene4);
						primaryStage.show();
					}
				});

				tx2.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(dels);
						primaryStage.show();
					}
				});

				tx3.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(msc);
						primaryStage.show();
					}
				});

				tx4.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(prs);
						primaryStage.show();
					}
				});

				tx5.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scene);
						primaryStage.show();
					}
				});
				tx6.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
						primaryStage.setScene(sercs);
						primaryStage.show();
					}
				});
				
				
				
				
				
				primaryStage.setScene(scene3);
				primaryStage.show();
				
				
				
				/////////////////////////////////////Search media//////////////////////////////////
				
				
				GridPane serch = new GridPane();
				Label ff = new Label("Scerch Media ");
				ff.setFont(Font.font(25));
				ff.setFont(Font.font(null, FontWeight.BOLD, addingCus.getFont().getSize()));
				HBox hhb = new HBox();
				hhb.setAlignment(Pos.CENTER);
				hhb.getChildren().add(ff);
				serc.setPadding(new Insets(0,20,10,20));
				serc.setTop(hhb);
				
				
				Text tit = new Text("Search BY Title");
				 tit.setFont(Font.font(35));
				 Text art = new Text("Search BY Artist");
				 art.setFont(Font.font(35));
				 Text song = new Text("Search BY Song");
				 song.setFont(Font.font(35));
				 Text rat = new Text("Search BY Rate");
			     rat.setFont(Font.font(35));
				 
				 TextField titf = new TextField();
				 titf.setPrefColumnCount(25);
				 TextField artf = new TextField();
				 TextField songf = new TextField();
				 TextField ratf = new TextField();
				 serch.setAlignment(Pos.CENTER);
				 serch.add(tit, 0, 0);
				 serch.add(titf, 1, 0);
				 serch.add(art, 0, 1);
				 serch.add(artf, 1, 1);
				 serch.add(song, 0, 2);
				 serch.add(songf, 1, 2);
				 serch.add(rat, 0, 3);
				 serch.add(ratf, 1, 3);
				 serc.setCenter(serch);
				 
				 serch.setVgap(30);
				 serch.setHgap(30);
				 VBox vv = new VBox();
				 HBox ss =new HBox();
				TextArea see = new TextArea();
				
				see.setMaxWidth(800);
				see.setDisable(true);
				
				
				ImageView fm3 = new ImageView("search2222-icon.png");
				fm3.setFitWidth(40);
				fm3.setPreserveRatio(true);

				ImageView bm3 = new ImageView("Go-222back-icon.png");
				bm3.setFitWidth(40);
				bm3.setPreserveRatio(true);
				
				Button fs3 = new Button(null, fm3);
				
				Button bi3 = new Button(null, bm3);
				HBox bh3 = new HBox();
				bh3.setSpacing(150);
				bh3.getChildren().addAll(bi3, fs3);
				bh3.setAlignment(Pos.CENTER);

				bi3.setOnAction(k -> primaryStage.setScene(scene3));

				VBox vb3 = new VBox();
				vb3.setAlignment(Pos.CENTER);
				vb3.setPadding(new Insets(20, 20, 20, 20));
				vb3.setSpacing(15);
				vb3.getChildren().addAll(see, bh3);
                  serc.setBottom(vb3);
                  
                  fs3.setOnAction(w->{
                	  if(titf.getText().trim().isEmpty()&& ratf.getText().trim().isEmpty()&&songf.getText().trim().isEmpty()&&artf.getText().trim().isEmpty()){
                		  see.setText((ridi.searchMedia2("*","*", "*", "*")).toString());
                	  }
                	  else if((!titf.getText().trim().isEmpty())&& ratf.getText().trim().isEmpty()&&songf.getText().trim().isEmpty()&&artf.getText().trim().isEmpty()){
                		  see.setText((ridi.searchMedia2(titf.getText(),"*", "*", "*")).toString());
                	  }
                	  else if((titf.getText().trim().isEmpty())&& (!ratf.getText().trim().isEmpty())&&songf.getText().trim().isEmpty()&&artf.getText().trim().isEmpty()) {
                		  see.setText((ridi.searchMedia2("*",ratf.getText(), "*", "*")).toString());
                	  }
                	  else if((titf.getText().trim().isEmpty())&& (ratf.getText().trim().isEmpty())&&(!songf.getText().trim().isEmpty())&&artf.getText().trim().isEmpty()) {
                		  see.setText((ridi.searchMedia2("*","*", "*", songf.getText())).toString());
                	  }
                	  else if((titf.getText().trim().isEmpty())&& (ratf.getText().trim().isEmpty())&&songf.getText().trim().isEmpty()&&(!artf.getText().trim().isEmpty())) {
                		  see.setText((ridi.searchMedia2("*","*",artf.getText() , "*")).toString());
                	  }
                	  else {
                		  see.setText((ridi.searchMedia2(tit.getText(),ratf.getText(),artf.getText(),songf.getText()).toString()));
                	  }
                	   
                	  
                  });
                  titf.setOnKeyPressed(w->{
                	  see.clear();
                	  ratf.clear();
                	  artf.clear();
                	  songf.clear();
                  });
                  ratf.setOnKeyPressed(w->{
                	  see.clear();
                	  artf.clear();
                	  songf.clear();
                	  titf.clear();
                  });
                  artf.setOnKeyPressed(w->{
                	  see.clear();
                	  ratf.clear();
                	  songf.clear();
                	  titf.clear();
                  });
                  songf.setOnKeyPressed(w->{
                	  see.clear();
                	  ratf.clear();
                	  artf.clear();
                	  titf.clear();
                  });
				

				String[] x = { "Movie", "Game", "Album" };
				HBox combh = new HBox();
				combh.setAlignment(Pos.CENTER);
//
				ComboBox combox = new ComboBox(FXCollections.observableArrayList(x));
				combox.getEditor().setFont(Font.font(40));
				combh.setPadding(new Insets(50, 0, 0, 0));
				combox.setPadding(new Insets(20, 20, 20, 40));
				combox.setPromptText("Choose media");
				combox.setStyle("-fx-font-size: 15pt;-fx-font-weight: bold;");
				combox.setPrefWidth(400);
				combh.getChildren().add(combox);
				gg.setTop(combh);
				EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {

						if (combox.getValue() == "Movie") {
							combox.setValue(x[0]);
							GridPane movi = new GridPane();

							movi.setAlignment(Pos.CENTER);
							movi.setPadding(new Insets(15, 10, 15, 20));
							movi.setHgap(15);
							movi.setVgap(20);

							Label addingm = new Label("please Enter Movie Information:");
							addingm.setFont(Font.font(40));
							addingm.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));

							movi.add(addingm, 0, 0);
							Label code = new Label("Movie Code:");
							code.setFont(Font.font(30));
							Label tit = new Label("Movie Title :");
							tit.setFont(Font.font(30));
							Label rat = new Label("Movie Rating:");
							rat.setFont(Font.font(30));
							Label numc = new Label("Number Of Coppy:");
							numc.setFont(Font.font(30));

							TextField c = new TextField();
							c.setPrefColumnCount(30);
							TextField t = new TextField();
							String[] wwe = { "AC", "HR", "DR" };
							ComboBox r = new ComboBox(FXCollections.observableArrayList(wwe));
							r.setPromptText("Select Rating");
							r.setPrefSize(400, 20);
							r.setStyle("-fx-font-size: 11pt;-fx-font-weight: bold;");
							TextField n = new TextField();

							t.setDisable(true);
							r.setDisable(true);
							n.setDisable(true);

							c.setOnKeyReleased(w -> {
								t.setDisable(false);
								r.setDisable(true);
								n.setDisable(true);
							});

							t.setOnKeyReleased(w -> {

								r.setDisable(false);
								n.setDisable(true);
							});

							
							r.setOnAction(w -> {

								n.setDisable(false);
							});
						

							movi.add(code, 0, 1);
							movi.add(c, 1, 1);
							movi.add(tit, 0, 2);
							movi.add(t, 1, 2);
							movi.add(rat, 0, 3);
							movi.add(r, 1, 3);
							movi.add(numc, 0, 4);
							movi.add(n, 1, 4);

							ImageView plusg = new ImageView("add-user-icon.png");
							plusg.setFitWidth(50);
							plusg.setPreserveRatio(true);
							ImageView bg = new ImageView("Go-222back-icon.png");
							bg.setFitWidth(50);
							bg.setPreserveRatio(true);
							Button ad = new Button(null, plusg);
							Button bk = new Button(null, bg);
							movi.add(bk, 0, 6);
							movi.add(ad, 1, 6);

							ad.setOnAction(k -> {
								
								n.setStyle("-fx-border-color: white ; -fx-border-width: 0px ;");
								try {

									ridi.addMovie(t.getText(), Integer.parseInt(n.getText()), String.valueOf(r.getValue()), c.getText());
									Text mass = new Text("\t\t\t\t\t\t\t\tMovie Added Succesfully");
									mass.setFill(Color.GREEN);
									mass.setFont(Font.font(15));
									movi.add(mass, 0, 9);
									c.clear();
									t.clear();
									
									n.clear();
								}catch (Exception eo) {
								n.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
								}
								

							});
							gg.setCenter(movi);
							bk.setOnAction(k -> primaryStage.setScene(scene3));

							Label sss = new Label("MOST POUPULAR :");
							sss.setAlignment(Pos.CENTER_LEFT);
							sss.setTextFill(Color.DARKRED);
							sss.setUnderline(true);
							sss.setFont(Font.font(30));

							VBox ww = new VBox();
							ww.setPadding(new Insets(20, 0, 0, 0));
							ww.setSpacing(10);
							ImageView addq = new ImageView("Action-icon.png");

							addq.setFitWidth(200);
							addq.setPreserveRatio(true);
							ImageView adsd = new ImageView("Magic-2-icon.png");

							adsd.setFitWidth(200);
							adsd.setPreserveRatio(true);

							ImageView addm = new ImageView("Horror-2-icon.png");
							addm.setFitWidth(200);
							addm.setPreserveRatio(true);
							ww.getChildren().addAll(sss, addq, addm, adsd);

							gg.setLeft(ww);

						} else if (combox.getValue() == "Game") {

							GridPane game = new GridPane();

							game.setAlignment(Pos.CENTER);
							game.setPadding(new Insets(15, 10, 15, 20));
							game.setHgap(15);
							game.setVgap(20);

							Label addingm = new Label("please Enter Game Information:");
							addingm.setFont(Font.font(40));
							addingm.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));

							game.add(addingm, 0, 0);
							Label code = new Label("Game Code:");
							code.setFont(Font.font(30));
							Label tit = new Label("Game Title :");
							tit.setFont(Font.font(30));
							Label wh = new Label("Game Wight(gm):");
							wh.setFont(Font.font(30));
							Label numc = new Label("Number Of Coppy:");
							numc.setFont(Font.font(30));

							TextField c = new TextField();
							c.setPrefColumnCount(30);
							TextField t = new TextField();
							TextField w = new TextField();
							TextField n = new TextField();

							t.setDisable(true);
							w.setDisable(true);
							n.setDisable(true);

							c.setOnKeyReleased(a -> {
								t.setDisable(false);
								w.setDisable(true);
								n.setDisable(true);
							});

							t.setOnKeyReleased(a -> {

								w.setDisable(false);
								n.setDisable(true);
							});

							w.setOnKeyReleased(a -> {

								n.setDisable(false);
							});

							game.add(code, 0, 1);
							game.add(c, 1, 1);
							game.add(tit, 0, 2);
							game.add(t, 1, 2);
							game.add(wh, 0, 3);
							game.add(w, 1, 3);
							game.add(numc, 0, 4);
							game.add(n, 1, 4);

							ImageView plusg = new ImageView("add-user-icon.png");
							plusg.setFitWidth(50);
							plusg.setPreserveRatio(true);
							ImageView bg = new ImageView("Go-222back-icon.png");
							bg.setFitWidth(50);
							bg.setPreserveRatio(true);
							Button ad = new Button(null, plusg);
							Button bk = new Button(null, bg);
							game.add(bk, 0, 6);
							game.add(ad, 1, 6);

							Label sss = new Label("MOST POUPULAR :");

							sss.setAlignment(Pos.CENTER_LEFT);
							sss.setTextFill(Color.DARKRED);
							sss.setUnderline(true);
							sss.setFont(Font.font(30));

							VBox ww = new VBox();
							ww.setPadding(new Insets(20, 0, 0, 0));
							ww.setSpacing(10);
							ImageView addq = new ImageView("game-need-for-speed-most-wanted-icon (1).png");

							addq.setFitWidth(200);
							addq.setPreserveRatio(true);
							ImageView adsd = new ImageView("Games-icon.png");

							adsd.setFitWidth(200);
							adsd.setPreserveRatio(true);

							ImageView addm = new ImageView("game-minecraft-icon.png");
							addm.setFitWidth(200);
							addm.setPreserveRatio(true);
							ww.getChildren().addAll(sss, addq, addm, adsd);

							gg.setLeft(ww);
							Text mass = new Text("\t\t\t\t\t\t\t\tGame Added Succesfully");
							ad.setOnAction(k -> {
								int flg=1;
								mass.setFill(Color.SKYBLUE);
								mass.setFont(Font.font(0.1));
								n.setStyle("-fx-border-color: white ; -fx-border-width: 0px ;");
								w.setStyle("-fx-border-color: white ; -fx-border-width: 0px ;");
								try {
									Integer.parseInt(n.getText());
									
								}
								catch (Exception eh) {
									n.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
									flg=0;
									}
								
								try {
									Double.parseDouble(w.getText());
								}
								catch (Exception eh) {
									w.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
									flg=0;
									}
							if(flg==1) {
								ridi.addGame(t.getText(), Integer.parseInt(n.getText()), Double.parseDouble(w.getText()),
										c.getText());
							
								mass.setFill(Color.GREEN);
								mass.setFont(Font.font(15));
								game.add(mass, 0, 9);
								c.clear();
								t.clear();
								w.clear();
								n.clear();
								
								}
							});
							c.setOnKeyPressed(d->{
								mass.setFill(Color.SKYBLUE);
								mass.setFont(Font.font(0.1));
							});
							gg.setCenter(game);
							bk.setOnAction(k -> primaryStage.setScene(scene3));

						}

						else {

							GridPane album = new GridPane();

							album.setAlignment(Pos.CENTER);
							album.setPadding(new Insets(15, 10, 15, 20));
							album.setHgap(15);
							album.setVgap(20);

							Label addingm = new Label("please Enter Album Information:");
							addingm.setFont(Font.font(40));
							addingm.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));

							album.add(addingm, 0, 0);
							Label code = new Label("Album Code:");
							code.setFont(Font.font(30));
							Label tit = new Label("Album Title :");
							tit.setFont(Font.font(30));
							Label rat = new Label("Artist:");
							rat.setFont(Font.font(30));
							Label nas = new Label("Song/s name:");
							nas.setFont(Font.font(30));

							Label numc = new Label("Number Of Coppy:");
							numc.setFont(Font.font(30));

							TextField c = new TextField();
							c.setPrefColumnCount(30);
							TextField t = new TextField();
							TextField r = new TextField();
							TextField s = new TextField();
							TextField ne = new TextField();

							t.setDisable(true);
							r.setDisable(true);
							ne.setDisable(true);
							s.setDisable(true);

							c.setOnKeyReleased(w -> {
								t.setDisable(false);
								r.setDisable(true);
								ne.setDisable(true);
								s.setDisable(true);
							});

							t.setOnKeyReleased(w -> {

								r.setDisable(false);
								ne.setDisable(true);
								s.setDisable(true);
							});

							r.setOnKeyReleased(w -> {

								s.setDisable(false);
								ne.setDisable(true);

							});
							s.setOnKeyReleased(w -> {
								ne.setDisable(false);
							});
							if (c.getText() == "") {
								t.setDisable(true);
								r.setDisable(true);
								ne.setDisable(true);
								s.setDisable(true);
							}
							album.add(code, 0, 1);
							album.add(c, 1, 1);
							album.add(tit, 0, 2);
							album.add(t, 1, 2);
							album.add(rat, 0, 3);
							album.add(r, 1, 3);
							album.add(nas, 0, 4);
							album.add(s, 1, 4);
							album.add(numc, 0, 5);
							album.add(ne, 1, 5);

							ImageView plusg = new ImageView("add-user-icon.png");
							plusg.setFitWidth(50);
							plusg.setPreserveRatio(true);
							ImageView bg = new ImageView("Go-222back-icon.png");
							bg.setFitWidth(50);
							bg.setPreserveRatio(true);
							Button ad = new Button(null, plusg);
							Button bk = new Button(null, bg);
							album.add(bk, 0, 6);
							album.add(ad, 1, 6);

							Label sss = new Label("MOST POUPULAR :");

							sss.setAlignment(Pos.CENTER_LEFT);
							sss.setTextFill(Color.DARKRED);
							sss.setUnderline(true);
							sss.setFont(Font.font(30));

							VBox ww = new VBox();
							ww.setPadding(new Insets(20, 0, 0, 10));
							ww.setSpacing(10);
							ImageView addq = new ImageView("folder-public-music-icon.png");

							addq.setFitWidth(200);
							addq.setPreserveRatio(true);
							ImageView adsd = new ImageView("File-Audio-icon.png");

							adsd.setFitWidth(200);
							adsd.setPreserveRatio(true);

							ImageView addm = new ImageView("Music-Piano-Chello-icon.png");
							addm.setFitWidth(200);
							addm.setPreserveRatio(true);
							ww.getChildren().addAll(sss, addq, addm, adsd);

							gg.setLeft(ww);

							ad.setOnAction(k -> {
								ne.setStyle("-fx-border-color: white ; -fx-border-width: 0px ;");
								try {
								ridi.addAlbum(t.getText(), Integer.parseInt(ne.getText()), r.getText(), s.getText(),
										c.getText());
								Text mass = new Text("\t\t\t\t\t\t\t\tAlbum Added Succesfully");
								mass.setFill(Color.GREEN);
								mass.setFont(Font.font(15));
								album.add(mass, 0, 9);
								c.clear();
								r.clear();
								s.clear();
								ne.clear();
								t.clear();
								}catch (Exception eo) {
									ne.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
									}
							});
							gg.setCenter(album);
							bk.setOnAction(k -> primaryStage.setScene(scene3));

						}

					}
				};

				combox.setOnAction(event);

				////////////////// Search / delete media///////////////
				HBox delb = new HBox();
				delb.setSpacing(60);
				Label ro = new Label("Please Enter Media Code");
				ro.setFont(Font.font(30));
				ro.setFont(Font.font(null, FontWeight.BOLD, addingCus.getFont().getSize()));

				TextField rof = new TextField();
				rof.setPrefColumnCount(30);
				rof.setFont(Font.font(15));
				
				delb.getChildren().addAll(ro, rof);

				delb.setAlignment(Pos.CENTER);

				delm.setPadding(new Insets(60, 30, 0, 0));

				ImageView fm = new ImageView("search2222-icon.png");
				fm.setFitWidth(40);
				fm.setPreserveRatio(true);

				ImageView bm = new ImageView("Go-222back-icon.png");
				bm.setFitWidth(40);
				bm.setPreserveRatio(true);
				Button fs = new Button(null, fm);

				ImageView dem = new ImageView("User-Delete-icon.png");
				dem.setFitWidth(40);
				dem.setPreserveRatio(true);

				TextArea tar3 = new TextArea();
				tar3.setFont(Font.font(15));
				tar3.setDisable(true);
				tar3.setPadding(new Insets(20, 50, 20, 50));
				delm.setCenter(tar3);

				fs.setOnAction(k -> {

					tar3.setText(ridi.secMedia(rof.getText()));

				});
				Button dl = new Button(null, dem);
				Button bi = new Button(null, bm);
				HBox bh = new HBox();
				bh.setSpacing(150);
				bh.getChildren().addAll(bi, fs, dl);
				bh.setAlignment(Pos.CENTER);

				bi.setOnAction(k -> primaryStage.setScene(scene3));

				dl.setOnAction(k -> {
					if (ridi.removemedia(rof.getText())) {
						Text delt = new Text("Media Has Deleted");
						delt.setFont(Font.font(15));
						delt.setFill(Color.GREEN);
						delb.getChildren().add(delt);

					} else {
						Text delt = new Text("Media Not Founded");
						delt.setFont(Font.font(15));
						delt.setFill(Color.RED);
						delb.getChildren().add(delt);
					}

				});
				VBox vb = new VBox();
				vb.setPadding(new Insets(20, 20, 20, 20));
				vb.setSpacing(15);
				vb.getChildren().addAll(delb, bh);
				delm.setTop(vb);

				//////////////// update media////////////////

				String[] y = { "Movie", "Game", "Album" };
				HBox uph = new HBox();
				uph.setAlignment(Pos.CENTER);

				ComboBox combup = new ComboBox(FXCollections.observableArrayList(y));
				combup.getEditor().setFont(Font.font(40));
				uph.setPadding(new Insets(50, 0, 0, 0));
				combup.setPadding(new Insets(20, 20, 20, 40));
				combup.setPromptText("Choose media");

				combup.setPrefWidth(400);
				uph.getChildren().add(combup);
				mup.setTop(uph);
				combup.getEditor().setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 40));
				EventHandler<ActionEvent> even = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {

						if (combup.getValue() == "Movie") {

							GridPane mov = new GridPane();
							mov.setAlignment(Pos.CENTER);
							mov.setPadding(new Insets(15, 10, 15, 20));
							mov.setHgap(15);
							mov.setVgap(20);
							Label addi = new Label("please Enter Movie Information:");
							addi.setFont(Font.font(40));
							addi.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));

							mov.add(addi, 0, 0);
							Label cod = new Label("Movie Code:");
							cod.setFont(Font.font(30));
							Label ti = new Label("Movie Title :");
							ti.setFont(Font.font(30));
							Label ra = new Label("Movie Rating:");
							ra.setFont(Font.font(30));
							Label nu = new Label("Number Of Coppy:");

							nu.setFont(Font.font(30));

							TextField c2 = new TextField();
							c2.setPrefColumnCount(30);
							TextField t2 = new TextField();
							TextField r2 = new TextField();
							TextField n2 = new TextField();

							mov.add(cod, 0, 1);
							mov.add(c2, 1, 1);
							mov.add(ti, 0, 2);
							mov.add(t2, 1, 2);
							mov.add(ra, 0, 3);
							mov.add(r2, 1, 3);
							mov.add(nu, 0, 4);
							mov.add(n2, 1, 4);

							ImageView plu = new ImageView("Save-icon.png");
							plu.setFitWidth(50);
							plu.setPreserveRatio(true);

							ImageView bgi = new ImageView("Go-222back-icon.png");
							bgi.setFitWidth(50);
							bgi.setPreserveRatio(true);
							Button ads = new Button("Save Update", plu);
							Button bki = new Button(null, bgi);
							mov.add(bki, 0, 6);
							mov.add(ads, 1, 6);

							ads.setOnAction(k -> {
								try {
								ridi.updateMovie(t2.getText(), Integer.parseInt(n2.getText()), r2.getText(),
										c2.getText());
								
								
								Text mas = new Text("\t\t\t\t\t\t\t\tMovie Updated Succesfully");
								mas.setFill(Color.GREEN);
								mas.setFont(Font.font(15));
								mov.add(mas, 0, 9);
								c2.clear();
								t2.clear();
								r2.clear();
								n2.clear();
								}
								catch (Exception e2) {
									// TODO: handle exception
								}

							});

							mup.setCenter(mov);
							bki.setOnAction(k -> primaryStage.setScene(scene3));

						}

						else if (combup.getValue() == "Game") {
							GridPane game = new GridPane();

							game.setAlignment(Pos.CENTER);
							game.setPadding(new Insets(15, 10, 15, 20));
							game.setHgap(15);
							game.setVgap(20);

							Label addingm = new Label("please Enter Game Information:");
							addingm.setFont(Font.font(40));
							addingm.setFont(Font.font(null, FontPosture.ITALIC, addingm.getFont().getSize()));

							game.add(addingm, 0, 0);
							Label code = new Label("Game Code:");
							code.setFont(Font.font(30));
							Label tit = new Label("Game Title :");
							tit.setFont(Font.font(30));
							Label rat = new Label("Game Wight(gm):");
							rat.setFont(Font.font(30));
							Label numc = new Label("Number Of Coppy:");
							numc.setFont(Font.font(30));

							TextField c = new TextField();
							c.setPrefColumnCount(30);
							TextField t = new TextField();
							TextField r = new TextField();
							TextField n = new TextField();

							game.add(code, 0, 1);
							game.add(c, 1, 1);
							game.add(tit, 0, 2);
							game.add(t, 1, 2);
							game.add(rat, 0, 3);
							game.add(r, 1, 3);
							game.add(numc, 0, 4);
							game.add(n, 1, 4);

							ImageView plusg = new ImageView("Save-icon.png");
							plusg.setFitWidth(50);
							plusg.setPreserveRatio(true);
							ImageView bg = new ImageView("Go-222back-icon.png");
							bg.setFitWidth(50);
							bg.setPreserveRatio(true);
							Button adi = new Button("Save Update", plusg);
							Button bk = new Button(null, bg);
							game.add(bk, 0, 6);
							game.add(adi, 1, 6);
							mup.setCenter(game);
							adi.setOnAction(k -> {
								try {
								ridi.updateGame(t.getText(), Integer.parseInt(n.getText()),
										Double.parseDouble(r.getText()), c.getText());
								Text mass = new Text("\t\t\t\t\t\t\t\tGame updated Succesfully");
								mass.setFill(Color.GREEN);
								mass.setFont(Font.font(15));
								game.add(mass, 0, 9);
								t.clear();
								c.clear();
								r.clear();
								n.clear();
								}catch (Exception ed) {
									// TODO: handle exception
								}

							});

							bk.setOnAction(k -> primaryStage.setScene(scene3));

						}

						else {

							GridPane album = new GridPane();

							album.setAlignment(Pos.CENTER);
							album.setPadding(new Insets(15, 10, 15, 20));
							album.setHgap(15);
							album.setVgap(20);

							Label addingm = new Label("please Enter Album Information:");
							addingm.setFont(Font.font(40));
							addingm.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));

							album.add(addingm, 0, 0);
							Label code = new Label("Album Code:");
							code.setFont(Font.font(30));
							Label tit = new Label("Album Title :");
							tit.setFont(Font.font(30));
							Label rat = new Label("Artist:");
							rat.setFont(Font.font(30));
							Label nas = new Label("Song/s name:");
							nas.setFont(Font.font(30));

							Label numc = new Label("Number Of Coppy:");
							numc.setFont(Font.font(30));

							TextField c = new TextField();
							c.setPrefColumnCount(30);
							TextField t = new TextField();
							n.setDisable(true);
							TextField r = new TextField();
							TextField n = new TextField();
							TextField s = new TextField();

							album.add(code, 0, 1);
							album.add(c, 1, 1);
							album.add(tit, 0, 2);
							album.add(t, 1, 2);
							album.add(rat, 0, 3);
							album.add(r, 1, 3);
							album.add(nas, 0, 4);
							album.add(s, 1, 4);
							album.add(numc, 0, 5);
							album.add(n, 1, 5);

							ImageView plusg = new ImageView("Save-icon.png");
							plusg.setFitWidth(50);
							plusg.setPreserveRatio(true);
							ImageView bg = new ImageView("Go-222back-icon.png");
							bg.setFitWidth(50);
							bg.setPreserveRatio(true);
							Button ad = new Button("Save Update", plusg);
							Button bk = new Button(null, bg);
							album.add(bk, 0, 6);
							album.add(ad, 1, 6);

							ad.setOnAction(k -> {
								try {
								ridi.updateAlbum(t.getText(), Integer.parseInt(n.getText()), r.getText(), s.getText(),
										c.getText());

								Text mass = new Text("\t\t\t\t\t\t\t\tAlbum Updated Succesfully");
								mass.setFill(Color.GREEN);
								mass.setFont(Font.font(15));
								album.add(mass, 0, 9);
								t.clear();
								r.clear();
								s.clear();
								c.clear();
								n.clear();
								}catch (Exception ep) {
									// TODO: handle exception
								}
							});
							mup.setCenter(album);
							bk.setOnAction(k -> primaryStage.setScene(scene3));

						}

					}
				};
				combup.setOnAction(even);

				print.setPadding(new Insets(70, 70, 70, 70));
				HBox phb = new HBox();
				phb.setPadding(new Insets(40, 0, 40, 40));

				Text ttt = new Text(" All information of media");
				ttt.setFont(Font.font(70));
				ttt.setUnderline(true);
				ttt.setFont(Font.font(null, FontPosture.ITALIC, addingCus.getFont().getSize()));

				phb.getChildren().add(ttt);
				phb.setAlignment(Pos.CENTER);

				TextArea tar = new TextArea(null);
				tar.setDisable(true);
				tar.setFont(Font.font(30));
				tar.setDisable(true);

				ImageView bb = new ImageView("Go-222back-icon.png");
				Button pb = new Button(null, bb);
				bb.setFitWidth(40);
				bb.setPreserveRatio(true);
				pb.setAlignment(Pos.CENTER);

				ImageView pr = new ImageView("Programming-Show-Property-icon.png");
				Button prb = new Button(null, pr);
				pr.setFitWidth(40);
				pr.setPreserveRatio(true);
				prb.setAlignment(Pos.CENTER);
				HBox hha = new HBox();
				hha.setSpacing(1000);
				hha.getChildren().addAll(pb, prb);
				print.setBottom(hha);
				prb.setOnAction(s -> {
					try {
						tar.setText(ridi.getAllMediaInfo());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				});

				pb.setOnAction(s -> {

					primaryStage.setScene(scene3);
				});
				print.setCenter(tar);

				print.setTop(phb);

				primaryStage.setScene(scene3);
				primaryStage.show();

			});

			rbn.setOnAction(e -> {

				pane2.setPadding(new Insets(40, 40, 20, 40));
				Label sss = new Label(" 30 % SALE !");
				sss.setAlignment(Pos.CENTER_LEFT);
				sss.setTextFill(Color.RED);
				sss.setUnderline(true);
				sss.setFont(Font.font(30));
				rent.setTop(sss);
				VBox ww = new VBox();
				ww.setPadding(new Insets(20, 0, 0, 0));
				ww.setSpacing(70);
				ImageView addq = new ImageView("New-Years-Eve-icon.png");

				addq.setFitWidth(300);

				addq.setLayoutX(0);
				addq.setLayoutY(100);
				addq.setPreserveRatio(true);

				rent.setLeft(addq);

				ImageView addm = new ImageView("BD-Files-icon.png");

				ww.getChildren().addAll(addq, addm);

				rent.setLeft(ww);

				GridPane gp = new GridPane();
				gp.setVgap(15);
				gp.setPadding(new Insets(0, 0, 0, 0));
				gp.setAlignment(Pos.CENTER);
				Text tx0 = new Text("> Please Select One <");
				tx0.setFill(Color.DARKRED);
				tx0.setUnderline(true);
				tx0.setFont(Font.font(60));

				Text tx1 = new Text("1- Rent Media");
				tx1.setFont(Font.font(40));
				tx1.setEffect(shadow);
				Text tx2 = new Text("2- Return Media");
				tx2.setFont(Font.font(40));
				tx2.setEffect(shadow);
				Text tx3 = new Text("3- Print the requested interested media in the cart");
				tx3.setFont(Font.font(40));
				tx3.setEffect(shadow);
				Text tx4 = new Text("4- Print the rented media in the cart");
				tx4.setFont(Font.font(40));
				tx4.setEffect(shadow);
				Text tx5 = new Text("5- Return to main page");
				tx5.setFont(Font.font(40));
				tx5.setEffect(shadow);
				gp.add(tx0, 0, 0);
				gp.add(tx1, 0, 1);
				gp.add(tx2, 0, 2);
				gp.add(tx3, 0, 3);
				gp.add(tx4, 0, 4);
				gp.add(tx5, 0, 5);

				rent.setCenter(gp);

				tx1.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx1.setFill(Color.BLUE);
						tx2.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);
						tx1.setUnderline(true);
						tx2.setUnderline(false);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
					}
				});
				tx2.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx2.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);

						tx1.setUnderline(false);
						tx2.setUnderline(true);
						tx3.setUnderline(false);
						tx4.setUnderline(false);
						tx5.setUnderline(false);

					}
				});

				tx3.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx3.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);

						tx2.setUnderline(false);
						tx3.setUnderline(true);
						tx4.setUnderline(false);
						tx5.setUnderline(false);
						tx1.setUnderline(false);

					}
				});
				tx4.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx4.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx5.setFill(Color.BLACK);

						tx4.setUnderline(true);
						tx3.setUnderline(false);
						tx5.setUnderline(false);
						tx2.setUnderline(false);
						tx1.setUnderline(false);

					}
				});
				tx5.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						tx5.setFill(Color.BLUE);
						tx1.setFill(Color.BLACK);
						tx3.setFill(Color.BLACK);
						tx4.setFill(Color.BLACK);
						tx2.setFill(Color.BLACK);
						tx5.setUnderline(true);
						tx4.setUnderline(false);
						tx3.setUnderline(false);
						tx2.setUnderline(false);
						tx1.setUnderline(false);

					}
				});

				tx1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scene5);
						primaryStage.show();
					}
				});

				tx2.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scene6);
						primaryStage.show();
					}
				});

				tx3.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scart);
						primaryStage.show();
					}
				});

				tx4.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(sren);
						primaryStage.show();
					}
				});

				tx5.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me) {

						primaryStage.setScene(scene);
						primaryStage.show();

					}
				});

				primaryStage.setScene(scenerent);
				primaryStage.show();

			});

			////// add rent//////////

			GridPane pane3 = new GridPane();
			pn.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			pane3.setAlignment(Pos.CENTER);
			pane3.setPadding(new Insets(1, 1, 1, 1));
			pane3.setHgap(10);
			pane3.setVgap(20);
			TextField lid = new TextField();
			lid.setFont(Font.font(15));
			Label kl = new Label("Costomer ID:");
			kl.setFont(Font.font(25));
			pane3.add(kl, 0, 0);
			pane3.add(lid, 1, 0);

			ImageView ff = new ImageView("search2222-icon.png");
			Button btf = new Button(null, ff);
			ff.setFitWidth(20);
			ff.setPreserveRatio(true);
			pane3.add(btf, 2, 0);

			TextArea ta1 = new TextArea();
		//	ta1.setDisable(true);
			pane3.add(ta1, 1, 1);

			Label km = new Label("Media Code:");
			km.setFont(Font.font(25));
			pane3.add(km, 0, 2);
			TextField midt = new TextField();
			midt.setFont(Font.font(15));
			pane3.add(midt, 1, 2);
			ImageView ff2 = new ImageView("search2222-icon.png");
			Button btf2 = new Button(null, ff2);
			ff2.setFitWidth(20);
			ff2.setPreserveRatio(true);
			pane3.add(btf2, 2, 2);

			TextArea ta2 = new TextArea();
			ta2.setDisable(true);
			pane3.add(ta2, 1, 3);

			Date dat = new Date();
			String dd = Integer.toString(dat.getDate());
			String mm = Integer.toString((dat.getMonth() + 1));
			String yy = Integer.toString(dat.getYear() + 1900);
			TextField datef = new TextField();
			datef.setFont(Font.font(15));
			datef.setDisable(true);
			datef.setText(dd + "/" + mm + "/" + yy);
			Label kd = new Label("Rented Date:");
			kd.setFont(Font.font(25));
			pane3.add(kd, 0, 4);
			pane3.add(datef, 1, 4);
			btf2.setOnAction(s -> {
				ta2.setText(ridi.secMedia(midt.getText()));

			});
			btf.setOnAction(s -> {
				ta1.setText(ridi.secCustomer(lid.getText()) +"\n"+ridi.printCart(lid.getText()));

			});
		
			HBox hb = new HBox();
			hb.setSpacing(100);
			Button btAdd = new Button("Add to Cart");
			btAdd.setFont(Font.font(15));

			Button btremove = new Button("Remove Frome Cart");
			btremove.setFont(Font.font(15));

			btremove.setOnAction(e -> {
				ridi.removeFromCart(lid.getText(), midt.getText());

			});
			
			btAdd.setOnAction(s -> {
				
					try {
						ridi.addToCart(lid.getText(), midt.getText());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					

			});
			Button btprs = new Button("Prosses cart");
			btprs.setFont(Font.font(15));
			TextField textt = new TextField();
			textt.setFont(Font.font(15));
			textt.setDisable(true);
			
			pane3.add(textt, 1, 6);
        
			btprs.setOnAction(s -> {
				datar="";
				try {
					
					datar=ridi.processRequests();
					textt.setText(datar);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lid.clear();
				midt.clear();
				
			});
			
			
			
			VBox vv = new VBox();
			vv.setSpacing(15);
			vv.setAlignment(Pos.CENTER_LEFT);
			ImageView addm2 = new ImageView("Christmas-Tree-icon.png");
			addm2.setFitWidth(300);
			addm2.setPreserveRatio(true);

			ImageView ad = new ImageView("Christmas-Present-1-icon.png");

			ad.setFitWidth(200);
			ad.setPreserveRatio(true);

			vv.getChildren().addAll(addm2, ad);

			ImageView bg = new ImageView("Go-222back-icon.png");
			Button bts = new Button("Back", bg);
			bts.setFont(Font.font(15));
			bg.setFitWidth(25);
			bg.setPreserveRatio(true);

			hb.getChildren().addAll(btAdd, btremove, btprs, bts);
			pane3.add(hb, 1, 5);
			
			
			pn.setCenter(pane3);
			pn.setLeft(vv);
			
			bts.setOnAction(s -> {

				primaryStage.setScene(scenerent);
			});
			
				
			

			primaryStage.setScene(scene5);
			primaryStage.show();

			////////////////////////// print cart///////////////////
			HBox shb6 = new HBox();
			shb6.setSpacing(60);
			Label si6 = new Label("Please Enter Customer ID ");
			si6.setFont(Font.font(30));
			si6.setFont(Font.font(null, FontWeight.BOLD, addingCus.getFont().getSize()));

			TextField itf6 = new TextField();

			itf6.setPrefColumnCount(30);
			itf6.setFont(Font.font(15));
			shb6.getChildren().addAll(si6, itf6);

			shb6.setAlignment(Pos.CENTER);

			pcart.setPadding(new Insets(60, 30, 0, 0));

			ImageView findim6 = new ImageView("search2222-icon.png");
			findim6.setFitWidth(40);
			findim6.setPreserveRatio(true);

			ImageView bakim6 = new ImageView("Go-222back-icon.png");
			bakim6.setFitWidth(40);
			bakim6.setPreserveRatio(true);
			Button finds6 = new Button(null, findim6);
			finds6.setDisable(true);

			Button backi6 = new Button(null, bakim6);
			HBox hbtn6 = new HBox();
			hbtn6.setSpacing(150);
			hbtn6.getChildren().addAll(backi6, finds6);
			hbtn6.setAlignment(Pos.CENTER);

			backi6.setOnAction(e -> primaryStage.setScene(scenerent));

			VBox idvb6 = new VBox();
			idvb6.setSpacing(15);
			idvb6.getChildren().addAll(shb6, hbtn6);
			pcart.setTop(idvb6);

			TextArea tar26 = new TextArea(null);
			tar26.setMaxWidth(1100);
			tar26.setMaxHeight(500);
			tar26.setPadding(new Insets(50, 50, 50, 50));
			tar26.setFont(Font.font(20));
			tar26.setDisable(true);
			itf6.setOnKeyReleased(w -> {
				finds6.setDisable(false);
			});

			finds6.setOnAction(e -> {

				tar26.setText(ridi.printCart(itf6.getText()));

				itf6.clear();

			});
			pcart.setCenter(tar26);

			/////////////////// return media//////////////////////

			GridPane pane3x = new GridPane();
			pane3x.setAlignment(Pos.CENTER);
			pane3x.setHgap(10);
			pane3x.setVgap(20);
			TextField lidx = new TextField();
			lidx.setFont(Font.font(15));
			Label klx = new Label("Costomer ID:");
			klx.setFont(Font.font(25));
			pane3x.add(klx, 0, 0);
			pane3x.add(lidx, 1, 0);

			ImageView ffx = new ImageView("search2222-icon.png");
			Button btfx = new Button(null, ffx);
			ffx.setFitWidth(15);
			ffx.setPreserveRatio(true);
			pane3x.add(btfx, 2, 0);

			TextArea tax = new TextArea();
			tax.setMaxSize(850, 500);
		 	tax.setDisable(true);
			pane3x.add(tax, 1, 1);

			Label kmx = new Label("Media Code:");
			kmx.setFont(Font.font(25));
			pane3x.add(kmx, 0, 2);
			TextField midtx = new TextField();
			midtx.setFont(Font.font(15));
			midtx.setPrefColumnCount(40);
			pane3x.add(midtx, 1, 2);
			ImageView ff2x = new ImageView("search2222-icon.png");
			Button btf2x = new Button(null, ff2x);
			ff2x.setFitWidth(20);
			ff2x.setPreserveRatio(true);
			pane3x.add(btf2x, 2, 2);

			TextArea ta2x = new TextArea();
			ta2x.setDisable(true);
			pane3x.add(ta2x, 1, 3);

			Date datx = new Date();
			String ddx1 = Integer.toString(dat.getDate());
			String mmx = Integer.toString((dat.getMonth() + 1));
			String yyx = Integer.toString(dat.getYear() + 1900);
			TextField datefx = new TextField();
			datefx.setFont(Font.font(15));
			datefx.setDisable(true);
			datefx.setText(ddx1 + "/" + mmx + "/" + yyx);
			Label kdx = new Label("Return Date:");
			kdx.setFont(Font.font(25));
			pane3x.add(kdx, 0, 4);
			pane3x.add(datefx, 1, 4);

			btf2x.setOnAction(s -> {
				ta2x.setText(ridi.secMedia(midtx.getText()));

			});
			btfx.setOnAction(s -> {
				tax.setText(ridi.secCustomer(lidx.getText()) );

			});

			HBox hbx = new HBox();
			hbx.setSpacing(100);
			Button btAddx = new Button("RETURN");
			btAddx.setFont(Font.font(15));
			btAddx.setOnAction(s -> {

				if (ridi.returnMedia(lidx.getText(), midtx.getText())) {
					Text cc = new Text("returnd sucsesfully");
					cc.setFont(Font.font(15));
					HBox thb =new HBox();
					thb.setAlignment(Pos.CENTER);
					thb.getChildren().add(cc);
				
					cc.setFill(Color.GREEN);
					reet.setBottom(thb);
					try {
						ridi.addToCart(lid.getText(), midtx.getText());
					

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			});

			VBox vvx = new VBox();
			vvx.setSpacing(15);
			vvx.setAlignment(Pos.CENTER_LEFT);
			ImageView addmx = new ImageView("Nutcracker-icon.png");
			addmx.setFitWidth(300);
			addmx.setPreserveRatio(true);

			ImageView adx = new ImageView("Bag-icon.png");

			adx.setFitWidth(200);
			adx.setPreserveRatio(true);

			vvx.getChildren().addAll(addmx, adx);

			ImageView bgx = new ImageView("Go-222back-icon.png");
			Button btsx = new Button("Back", bgx);
			btsx.setFont(Font.font(15));
			bgx.setFitWidth(25);
			bgx.setPreserveRatio(true);

			hbx.getChildren().addAll(btAddx, btsx);
			pane3x.add(hbx, 1, 5);
			reet.setCenter(pane3x);
			reet.setLeft(vvx);
			btsx.setOnAction(s -> {

				primaryStage.setScene(scenerent);
			});

			////////////////////////// print media///////////////////
			HBox shb61 = new HBox();
			shb61.setSpacing(60);
			Label si61 = new Label("Please Enter Customer ID ");
			si61.setFont(Font.font(30));
			si61.setFont(Font.font(null, FontWeight.BOLD, addingCus.getFont().getSize()));

			TextField itf61 = new TextField();

			itf61.setPrefColumnCount(30);
			itf61.setFont(Font.font(15));
			shb61.getChildren().addAll(si61, itf61);

			shb61.setAlignment(Pos.CENTER);

			pren.setPadding(new Insets(60, 30, 0, 0));

			ImageView findim61 = new ImageView("search2222-icon.png");
			findim61.setFitWidth(40);
			findim61.setPreserveRatio(true);

			ImageView bakim61 = new ImageView("Go-222back-icon.png");
			bakim61.setFitWidth(40);
			bakim61.setPreserveRatio(true);
			Button finds61 = new Button(null, findim61);
			finds61.setDisable(true);

			Button backi61 = new Button(null, bakim61);
			HBox hbtn61 = new HBox();
			hbtn61.setSpacing(150);
			hbtn61.getChildren().addAll(backi61, finds61);
			hbtn61.setAlignment(Pos.CENTER);

			backi61.setOnAction(e -> primaryStage.setScene(scenerent));

			VBox idvb61 = new VBox();
			idvb61.setSpacing(15);
			idvb61.getChildren().addAll(shb61, hbtn61);
			pren.setTop(idvb61);

			TextArea tar261 = new TextArea(null);
			tar261.setMaxWidth(1100);
			tar261.setMaxHeight(500);
			tar261.setPadding(new Insets(50, 50, 50, 50));
			tar261.setFont(Font.font(20));
			tar261.setDisable(true);
			itf61.setOnKeyReleased(w -> {
				finds61.setDisable(false);
			});

			finds61.setOnAction(e -> {

				tar261.setText(ridi.printrented(itf61.getText()));

				itf61.clear();

			});
			pren.setCenter(tar261);

			primaryStage.setScene(scene6);
			

			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		launch(args);

	}
}