;dosseg
.model small
.stack
.data
    value db 03bh 
    message db 'sum = $'   
.code
    
    main proc
        mov ax,@data
        mov ds,ax
        
        mov ax,0
        mov al,value
        ;mov ah,0
        
        ;mov bl,num2
        ;mov bh,0
        
        ;add al,value
        
        aam 
        
        add ax,3030h ;converting to ASCII
        
        push ax
        
        lea dx,message
        mov ah,09h
        int 21h
        
        pop ax
        
        mov dl,ah
        mov dh,al
        
        mov ah,02h
        int 21h
        
        mov dl,dh
        mov ah,02h
        int 21h
        
        mov ax,4c00h
        int 21h
        
        main endp
    end main
    