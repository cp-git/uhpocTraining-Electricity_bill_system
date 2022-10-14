PGDMP     +    (            	    z            Electric_Bill    13.8    13.8     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    18482    Electric_Bill    DATABASE     s   CREATE DATABASE "Electric_Bill" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "Electric_Bill";
                postgres    false            �            1259    18522    consumer    TABLE     P  CREATE TABLE public.consumer (
    cons_id integer NOT NULL,
    cons_name character varying NOT NULL,
    cons_number integer NOT NULL,
    cons_address1 character varying NOT NULL,
    cons_address2 character varying NOT NULL,
    cons_city character varying NOT NULL,
    cons_phone integer NOT NULL,
    dept_id integer NOT NULL
);
    DROP TABLE public.consumer;
       public         heap    postgres    false            �            1259    18520    consumer_cons_id_seq    SEQUENCE     �   ALTER TABLE public.consumer ALTER COLUMN cons_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.consumer_cons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    18492 
   department    TABLE     ~   CREATE TABLE public.department (
    dept_id integer NOT NULL,
    dept_name text,
    dept_city text,
    dept_state text
);
    DROP TABLE public.department;
       public         heap    postgres    false            �            1259    18490    department_dept_id_seq    SEQUENCE     �   ALTER TABLE public.department ALTER COLUMN dept_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.department_dept_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �            1259    18539    power    TABLE     �   CREATE TABLE public.power (
    p_id integer NOT NULL,
    reader_date date NOT NULL,
    p_cmr integer NOT NULL,
    reader_name character varying NOT NULL,
    cons_id integer NOT NULL
);
    DROP TABLE public.power;
       public         heap    postgres    false            �            1259    18537    power_p_id_seq    SEQUENCE     �   ALTER TABLE public.power ALTER COLUMN p_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.power_p_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �          0    18522    consumer 
   TABLE DATA           �   COPY public.consumer (cons_id, cons_name, cons_number, cons_address1, cons_address2, cons_city, cons_phone, dept_id) FROM stdin;
    public          postgres    false    203   A       �          0    18492 
   department 
   TABLE DATA           O   COPY public.department (dept_id, dept_name, dept_city, dept_state) FROM stdin;
    public          postgres    false    201   ^       �          0    18539    power 
   TABLE DATA           O   COPY public.power (p_id, reader_date, p_cmr, reader_name, cons_id) FROM stdin;
    public          postgres    false    205   {       �           0    0    consumer_cons_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.consumer_cons_id_seq', 1, false);
          public          postgres    false    202            �           0    0    department_dept_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.department_dept_id_seq', 1, false);
          public          postgres    false    200            �           0    0    power_p_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.power_p_id_seq', 1, false);
          public          postgres    false    204            4           2606    18536 !   consumer consumer_cons_number_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.consumer
    ADD CONSTRAINT consumer_cons_number_key UNIQUE (cons_number);
 K   ALTER TABLE ONLY public.consumer DROP CONSTRAINT consumer_cons_number_key;
       public            postgres    false    203            6           2606    18529    consumer consumer_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.consumer
    ADD CONSTRAINT consumer_pkey PRIMARY KEY (cons_id);
 @   ALTER TABLE ONLY public.consumer DROP CONSTRAINT consumer_pkey;
       public            postgres    false    203            2           2606    18499    department department_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (dept_id);
 D   ALTER TABLE ONLY public.department DROP CONSTRAINT department_pkey;
       public            postgres    false    201            8           2606    18546    power power_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.power
    ADD CONSTRAINT power_pkey PRIMARY KEY (p_id);
 :   ALTER TABLE ONLY public.power DROP CONSTRAINT power_pkey;
       public            postgres    false    205            :           2606    18547    power consumer_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.power
    ADD CONSTRAINT consumer_fk FOREIGN KEY (cons_id) REFERENCES public.consumer(cons_id) ON UPDATE CASCADE ON DELETE CASCADE;
 ;   ALTER TABLE ONLY public.power DROP CONSTRAINT consumer_fk;
       public          postgres    false    2870    203    205            9           2606    18530    consumer department_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.consumer
    ADD CONSTRAINT department_fk FOREIGN KEY (dept_id) REFERENCES public.department(dept_id) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.consumer DROP CONSTRAINT department_fk;
       public          postgres    false    201    203    2866            �      x������ � �      �      x������ � �      �      x������ � �     